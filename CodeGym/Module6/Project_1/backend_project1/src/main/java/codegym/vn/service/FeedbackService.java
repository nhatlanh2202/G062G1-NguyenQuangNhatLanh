package codegym.vn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface FeedbackService {
    Page<Feedback> findAll(int page);

    Feedback findById(Long id);

    void save(Feedback feedback);

    Specification<Feedback> getFilter(String customerName, String createDate, String processStatus);

    Page<Feedback> findFeedbackByCriteria(Specification<Feedback> specification, int page);

    List<Feedback> findAllFeedback();
}
