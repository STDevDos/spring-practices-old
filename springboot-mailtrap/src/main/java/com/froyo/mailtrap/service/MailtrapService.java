package com.froyo.mailtrap.service;

import com.froyo.mailtrap.dto.FeedbackDTO;
import com.froyo.mailtrap.dto.inout.SendFeedbackResponse;

public interface MailtrapService {
    SendFeedbackResponse sendFeedback(FeedbackDTO feedbackDTO);
}
