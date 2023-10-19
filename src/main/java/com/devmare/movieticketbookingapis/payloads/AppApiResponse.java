package com.devmare.movieticketbookingapis.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppApiResponse {
    public String message;
    public Boolean isSuccess;
}
