package com.fategen.NumerologyBot.util;

import com.fategen.NumerologyBot.dto.ErrorMessageDto;
import lombok.val;

import java.util.Date;

public class GenerateErrorMessage {

    public static ErrorMessageDto generateErrorMessageDto(String message) {
        val errorMessageDto = new ErrorMessageDto();
        errorMessageDto.setDate(new Date());
        errorMessageDto.setMessage(message);

        return errorMessageDto;
    }
}
