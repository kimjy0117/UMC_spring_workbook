package umc.spring.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        // Null check for `values` to prevent NullPointerException
        if (values == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.getMessage()).addConstraintViolation();
            return false; // Return false if the list is null
        }

        // Validate each value in the list
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;
    }
}
