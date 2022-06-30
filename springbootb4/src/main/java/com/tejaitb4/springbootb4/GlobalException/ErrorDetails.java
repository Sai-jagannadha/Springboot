package com.tejaitb4.springbootb4.GlobalException;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@JsonAutoDetect(getterVisibility=Visibility.ANY)
public class ErrorDetails {

	Date timestamp;
	String msg;
	String error;
}
