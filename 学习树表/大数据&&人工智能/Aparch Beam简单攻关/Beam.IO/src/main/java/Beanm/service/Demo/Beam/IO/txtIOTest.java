package Beanm.service.Demo.Beam.IO;

import org.apache.beam.runners.direct.DirectRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.KV;

public class txtIOTest {
	public static void main( String[] args ){
		PipelineOptions pipelineOptions = PipelineOptionsFactory.create();//通过管道工厂创建管道配置
		pipelineOptions.setRunner(DirectRunner.class);//设置运行的模型，现在一共三种(哪三种？)
		Pipeline pipeline = Pipeline.create(pipelineOptions);//创建配置好的管道
		//根据文件路径读取文件内容
		pipeline.apply(TextIO.read().from("/usr/local/text.txt")).apply("ExtractWords",ParDo.of(new DoFn<String, String>() {
			@ProcessElement
			public void processElement(ProcessContext c){
				for(String word : c.element().split(" ")){//根据空格读取数据，使用Lambda表达式
					if(!word.isEmpty()){
						c.output(word);
						System.out.println("读取数据："+word);
					}
				}
			}
		})).apply(Count.<String>perElement()).apply("FormatResult",MapElements.via(new SimpleFunction<KV<String, Long>, String>() {
			@Override
			public String apply(KV<String, Long> input){
				return input.getKey()+": "+input.getValue();
			}
		})).apply(TextIO.write().to("/usr/local/textcount"));
		pipeline.run().waitUntilFinish(); //運行直到管道流結束并返回状态
	}
}

