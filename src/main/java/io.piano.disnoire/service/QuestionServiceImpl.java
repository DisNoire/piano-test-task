package io.piano.disnoire.service;

import io.piano.disnoire.dto.AnswersDto;
import io.piano.disnoire.dto.ResponseDto;
import io.piano.disnoire.dto.ResponsesDto;
import io.piano.disnoire.param.Sort;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private HttpClient httpClient = HttpClientBuilder.create().build();
    private ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    @Override
    public ResponsesDto sendQuestionToStackoverflowAPI(String question, Sort sort) {
        String url = "http://api.stackexchange.com/2.2/search?" +
                "order={order}&" +
                "sort={sort}&" +
                "site={site}&" +
                "intitle={intitle}";

        HashMap<String, String> params = new HashMap<>();
        params.put("order", "desc");
        params.put("sort", sort.toString());
        params.put("intitle", question);
        params.put("site", "stackoverflow");
        AnswersDto items;
        List<ResponseDto> responses;

        try {
            items = restTemplate.getForObject(url, AnswersDto.class, params);

        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode());
        }

        responses = items.getItems().stream().map(ResponseDto::new).collect(Collectors.toList());

        return new ResponsesDto(responses);
    }
}
