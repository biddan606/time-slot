package com.biddan606.timeslot.docs;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.biddan606.timeslot.user.controller.UserController;
import com.biddan606.timeslot.user.controller.request.UserCreateRequest;
import com.biddan606.timeslot.user.domain.User;
import com.biddan606.timeslot.user.service.UserService;
import com.biddan606.timeslot.user.service.command.UserCreateCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

class UserControllerDocsTest extends RestDocsSupport {

    private final UserService userService = mock(UserService.class);

    @Override
    protected Object initController() {
        return new UserController(userService);
    }

    @DisplayName("유저를 등록하는 API")
    @Test
    void createUser() throws Exception {
        // given
        UserCreateRequest request = UserCreateRequest.builder()
                .loginId("user123")
                .nickname("유저 짱짱맨")
                .password("1234qwer")
                .build();

        given(userService.create(any(UserCreateCommand.class)))
                .willReturn(mock(User.class));

        // when // then
        mockMvc.perform(
                        post("/users")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andDo(document("user-create",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("loginId").type(JsonFieldType.STRING)
                                                .description("로그인 ID"),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING)
                                                .description("닉네임"),
                                        fieldWithPath("password").type(JsonFieldType.STRING)
                                                .description("비밀번호")
                                ),
                                responseFields(
                                        fieldWithPath("userId").type(JsonFieldType.NUMBER)
                                                .description("생성된 유저의 아이디")
                                )
                        )
                );
    }
}
