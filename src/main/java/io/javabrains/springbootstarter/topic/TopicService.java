package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	List<Topic> topicList = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Java Script", "Spring Framework Description")
			));
	
	public List<Topic> getAllTopics(){
		return topicList;
	}
	
	public Topic getTopic(String id) {
		return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get(); 
	}

	public void addTopic(Topic topic) {
		topicList.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i=0; i< topicList.size(); i ++) {
			Topic t = topicList.get(i);
			if(t.getId().equals(id)) {
				topicList.set(i, topic);
			}
		}
	}

	public void deleteTopic(String id) {
		topicList.removeIf(t -> t.getId().equals(id));
	}
	
}
