package com.nb.travelCNNB.config;

import org.springframework.stereotype.Component;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class WekaModelConfig {
	private Classifier decisionTreeModel;
	private Classifier knnModel;
	private Classifier bayesModel;
	private Instances dataset;
	
	public WekaModelConfig() {
		try {
			// Đọc dữ liệu từ file ARFF trong resources
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/tourism_data.arff");
			DataSource source = new DataSource(inputStream);
			dataset = source.getDataSet();
			if (dataset.classIndex() == -1) {
				dataset.setClassIndex(dataset.numAttributes() - 1);
			}
			String datasetPath = "src/main/resources/data/tourism_data.arff";

//			// Huấn luyện mô hình Decision Tree (J48)
//			decisionTreeModel = new J48();
//			decisionTreeModel.buildClassifier(dataset);
//
//			// Huấn luyện mô hình KNN
//			knnModel = new IBk(3);
//			knnModel.buildClassifier(dataset);
//
//			// Huấn luyện Naive Bayes
//			bayesModel = new NaiveBayes();
//			bayesModel.buildClassifier(dataset);
			
			// Tải hoặc huấn luyện Decision Tree
			decisionTreeModel = loadOrTrainModel("decision_tree.model", new J48(), datasetPath);
			
			// Tải hoặc huấn luyện KNN
			knnModel = loadOrTrainModel("knn.model", new IBk(3), datasetPath);
			
			// Tải hoặc huấn luyện Naive Bayes
			bayesModel = loadOrTrainModel("naive_bayes.model", new NaiveBayes(), datasetPath);
			
			String hashFilePath = "src/main/resources/data/dataset.hash";
			boolean isDatasetChanged = isDatasetChanged(datasetPath, hashFilePath);
			if (isDatasetChanged) {
				saveFileHash(hashFilePath, computeFileHash(datasetPath));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Classifier getDecisionTreeModel() {
		return decisionTreeModel;
	}
	
	public Classifier getKnnModel() {
		return knnModel;
	}
	
	public Classifier getBayesModel() {
		return bayesModel;
	}
	
	public Instances getDataset() {
		return dataset;
	}
	
	private Classifier loadOrTrainModel(String modelFileName, Classifier model, String datasetPath) throws Exception {
		
		String resourcePath = "src/main/resources/models";
		
		String hashFilePath = "src/main/resources/data/dataset.hash";
		
		boolean isDatasetChanged = isDatasetChanged(datasetPath, hashFilePath);
		File directory = new File(resourcePath);
		
		if (!directory.exists()) {
			directory.mkdir();
		}
		
		String filePath = resourcePath + "/" + modelFileName;
		File modelFile = new File(filePath);

//		if (modelFile.exists()) {
//			try {
//				return (Classifier) SerializationHelper.read(filePath);
//			} catch (Exception e) {
//				System.err.println("Model file is corrupted: " + modelFileName);
//				modelFile.delete(); // Xóa file hỏng
//				throw e;
//			}
//		} else {
//			model.buildClassifier(dataset);
//			SerializationHelper.write(filePath, model);
//			return model;
//		}
		if (!modelFile.exists() || isDatasetChanged) {
			System.out.println("Dataset changed or model file missing. Retraining " + modelFileName);
			model.buildClassifier(dataset);
			SerializationHelper.write(modelFile.getAbsolutePath(), model);
		} else {
			System.out.println("Loading " + modelFileName);
			model = (Classifier) SerializationHelper.read(modelFile.getAbsolutePath());
		}
//		if (isDatasetChanged) {
//			saveFileHash(hashFilePath, computeFileHash(datasetPath));
//		}
		return model;
		
	}
	
	private String computeFileHash(String filePath) throws IOException, NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		try (InputStream fis = new FileInputStream(filePath)) {
			byte[] byteArray = new byte[1024];
			int bytesCount;
			while ((bytesCount = fis.read(byteArray)) != -1) {
				digest.update(byteArray, 0, bytesCount);
			}
		}
		byte[] bytes = digest.digest();
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	
	private void saveFileHash(String hashFilePath, String hash) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(hashFilePath))) {
			writer.write(hash);
		}
	}
	
	private String loadFileHash(String hashFilePath) throws IOException {
		File file = new File(hashFilePath);
		if (!file.exists()) return null;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(hashFilePath))) {
			return reader.readLine();
		}
	}
	
	private boolean isDatasetChanged(String datasetPath, String hashFilePath) throws Exception {
		String currentHash = computeFileHash(datasetPath);
		String savedHash = loadFileHash(hashFilePath);
//		if (!currentHash.equals(savedHash)) {
////			saveFileHash(hashFilePath, currentHash);
//			return true;
//		}
//		return false;
		return !currentHash.equals(savedHash);
	}
	
	
	// Phương thức để huấn luyện lại mô hình
//	public void trainModel(String arffFilePath) {
//		try {
//			// Đọc dữ liệu từ file ARFF mới
//			DataSource source = new DataSource(arffFilePath);
//			dataset = source.getDataSet();
//			if (dataset.classIndex() == -1) {
//				dataset.setClassIndex(dataset.numAttributes() - 1);
//			}
//
//			// Tạo và huấn luyện mô hình mới
//			decisionTreeModel = new J48();
//			decisionTreeModel.buildClassifier(dataset);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
