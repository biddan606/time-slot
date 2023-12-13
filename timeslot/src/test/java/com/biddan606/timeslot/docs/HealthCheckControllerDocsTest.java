package com.biddan606.timeslot.docs;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseBody;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.biddan606.timeslot.HealthCheckController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HealthCheckControllerDocsTest extends RestDocsSupport {

    @Override
    protected Object initController() {
        return new HealthCheckController();
    }

    @DisplayName("실행중이라면 실행 중이라는 메시지를 준다.")
    @Test
    void healthCheck() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("애플리케이션이 실행중입니다!"))
                .andDo(document("health-check",
                        responseBody()
                ));
    }
}
