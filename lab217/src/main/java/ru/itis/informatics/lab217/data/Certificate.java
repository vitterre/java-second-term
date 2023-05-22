package ru.itis.informatics.lab217.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itis.informatics.lab217.JSONField;

@Data
@AllArgsConstructor
public class Certificate {
	@JSONField("enter_year")
	private String enterYear;

	@JSONField("graduation_year")
	private String graduationYear;
}