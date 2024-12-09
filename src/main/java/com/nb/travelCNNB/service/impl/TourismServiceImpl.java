package com.nb.travelCNNB.service.impl;

import com.nb.travelCNNB.config.WekaModelConfig;
import com.nb.travelCNNB.dto.TravelRecommendationRequest;
import com.nb.travelCNNB.dto.TravelRecommendationResponse;
import com.nb.travelCNNB.service.TourismService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.IOException;
import java.io.File;


@Service
public class TourismServiceImpl implements TourismService {
	
	@Autowired
	private WekaModelConfig wekaModelConfig;
	
	@Override
	public TravelRecommendationResponse predictDestination(TravelRecommendationRequest request) {
		try {
			// Lấy model dựa trên tên từ request
			Classifier model;
			switch (request.getModel().toLowerCase()) {
				case "knn":
					model = wekaModelConfig.getKnnModel();
					break;
				case "decisiontree":
					model = wekaModelConfig.getDecisionTreeModel();
					break;
				case "naivebayes":
					model = wekaModelConfig.getBayesModel();
					break;
				default:
					return new TravelRecommendationResponse("Unsupported model: " + request.getModel());
			}
			
			// Lấy model và dữ liệu từ Weka
			Instances dataset = wekaModelConfig.getDataset();
			Instance newCase = (Instance) dataset.firstInstance().copy(); // Tạo bản sao từ instance mẫu
			
			// Gán giá trị vào các thuộc tính của đối tượng dự đoán
			newCase.setValue(0, request.getAge());
			newCase.setValue(1, request.getWith());
			newCase.setValue(2, request.getBudget());
			newCase.setValue(3, request.getInterest());
			
			// Dự đoán điểm đến
			double prediction = model.classifyInstance(newCase);
			String predictedDestination = dataset.classAttribute().value((int) prediction);
			
			// Trả về kết quả
			return new TravelRecommendationResponse(predictedDestination);
		} catch (Exception e) {
			e.printStackTrace();
			return new TravelRecommendationResponse("Error in prediction");
		}
	}
}
