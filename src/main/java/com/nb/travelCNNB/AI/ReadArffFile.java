//package com.nb.travelCNNB.AI;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import weka.core.Instances;
//import weka.core.converters.ArffLoader;
//
//import java.io.File;
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class ReadArffFile {
//
//	public Instances readArffFile(String filePath) throws IOException {
//		ArffLoader loader = new ArffLoader();
//		File file = new File(filePath);
//		loader.setFile(file);
//
//		Instances data = loader.getDataSet();
//		if (data.classIndex() == -1) {
//			data.setClassIndex(data.numAttributes() - 1); // Giả sử lớp là thuộc tính cuối cùng
//		}
//		return data;
//	}
//
//}
