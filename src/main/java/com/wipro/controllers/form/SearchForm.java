package com.wipro.controllers.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchForm {

	@NotNull
	@Size(min = 2, max = 15)
	private String from;
	@NotNull
	@Size(min = 2, max = 15)
	private String to;

}
