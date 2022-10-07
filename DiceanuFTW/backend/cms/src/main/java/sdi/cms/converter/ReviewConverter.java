package sdi.cms.converter;

import org.springframework.stereotype.Component;
import sdi.cms.dto.ReviewDto;
import sdi.cms.model.paper.Review;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewConverter {

    public Review DtoToModel(ReviewDto dto) {
        Review review = new Review();
        review.setId(dto.getId());
        review.setGrade(dto.getGrade());
        return review;
    }

    public ReviewDto ModelToDto(Review review) {
        return ReviewDto.builder().id(review.getId()).grade(review.getGrade()).build();

    }

    public List<ReviewDto> modelsToDtos(List<Review> models) {
        return models.stream()
                .map(this::ModelToDto)
                .collect(Collectors.toList());
    }

    public List<Review> dtosToModels(List<ReviewDto> dtos) {
        return dtos.stream()
                .map(this::DtoToModel)
                .collect(Collectors.toList());
    }

}
