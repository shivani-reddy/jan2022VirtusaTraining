package com.virtusa.calendar.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.virtusa.calendar.configurations.VaultConfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties
public class VaultConfiguration {
	private String username;
	private String password;
}
