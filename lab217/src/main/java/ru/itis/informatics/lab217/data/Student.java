package ru.itis.informatics.lab217.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itis.informatics.lab217.JSONField;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
//	@JsonProperty("first_name")
	@JSONField("first_name")
	private String firstName;

//	@JsonProperty("last_name")
	@JSONField("first_name")
	private String lastName;

//	@JsonProperty("group")
	@JSONField("first_name")
	private String group;

//	@JsonProperty("certificate")
	@JSONField("certificate")
	private Certificate certificate;

	@JSONField("subjects")
	private List<String> subjects;

	@JSONField("grads")
	private int[] grads;

}
