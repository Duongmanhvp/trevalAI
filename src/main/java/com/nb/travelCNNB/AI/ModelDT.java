//package com.nb.travelCNNB.AI;
//
//import org.springframework.stereotype.Component;
//import weka.classifiers.Classifier;
//import weka.classifiers.trees.J48;
//import weka.core.Instances;
//import weka.core.SerializationHelper;
//
//@Component
//public class ModelDT {
//
//	public Classifier trainModel(Instances data) throws Exception {
//		J48 model = new J48();  // Sử dụng cây quyết định J48
//		model.buildClassifier(data); // Huấn luyện mô hình
//		return model;
//	}
//
//	public void saveModel(Classifier model, String filePath) throws Exception {
//		SerializationHelper.write(filePath, model); // Lưu mô hình đã huấn luyện
//	}
//
//	public Classifier loadModel(String filePath) throws Exception {
//		return (Classifier) SerializationHelper.read(filePath); // Tải mô hình đã lưu
//	}
//
//}
