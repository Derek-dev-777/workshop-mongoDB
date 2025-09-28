package com.example.Derek.workshop_API.Mappers.PostMapper;

import com.example.Derek.workshop_API.Models.DTOs.PostDTO.PostGetDTO;
import com.example.Derek.workshop_API.Models.Entities.PostEntity;

public class PostMapper {
	
	public static PostGetDTO convertEntityToDTO (PostEntity entity) {
		return new PostGetDTO(
				entity.getId(),
				entity.getCreatedAt(),
				entity.getTitle(),
				entity.getBody(),
				entity.getAuthor());
	}
	
}
