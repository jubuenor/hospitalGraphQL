package org.globant.domain.entities;

import org.globant.utils.RegexUtils;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * Contact
 */
// @Data
// public class ContactInformation {
//
// @Pattern(regexp = RegexUtils.PHONE_REGEX, message = "Phone must be a number
// with 8 to 10 digits")
// @NotNull(message = "Phone is required")
// private String phone;
//
// @Email
// @NotNull(message = "Email is required")
// private String email;
//
// @NotNull(message = "Address is required")
// @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Address must be
// alphanumeric")
// private String address;
//
// }

public record ContactInformation(
        @Pattern(regexp = RegexUtils.PHONE_REGEX, message = "Phone must be a number with 8 to 10 digits") @NotNull(message = "Phone is required") String phone,
        @Email @NotNull(message = "Email is required") String email,
        @NotNull(message = "Address is required") @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Address must be alphanumeric") String address) {
}
