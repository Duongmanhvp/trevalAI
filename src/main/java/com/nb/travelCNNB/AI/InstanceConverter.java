//package com.nb.travelCNNB.AI;
//
//import weka.core.Attribute;
//import weka.core.DenseInstance;
//import weka.core.Instances;
//
//import java.util.ArrayList;
//
//public class InstanceConverter {
//
//	public static Instances convertToInstances(UserDataDTO userData, Instances template) {
//		ArrayList<Attribute> attributes = new ArrayList<>(template.numAttributes());
//		for (int i = 0; i < template.numAttributes(); i++) {
//			attributes.add(template.attribute(i));
//		}
//
//		Instances data = new Instances("UserInstance", attributes, 1);
//		data.setClassIndex(template.classIndex()); // Đặt chỉ mục lớp
//
//		double[] instanceValues = new double[data.numAttributes()];
//		for (int i = 0; i < userData.getAttributes().size(); i++) {
//			instanceValues[i] = userData.getAttributes().get(i);
//		}
//
//		// Thêm giá trị lớp nếu có
//		if (userData.getClassName() != null) {
//			instanceValues[data.classIndex()] = data.classAttribute().indexOfValue(userData.getClassName());
//		}
//
//		data.add(new DenseInstance(1.0, instanceValues));
//		return data;
//	}
//}
