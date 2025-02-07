package com.qks.makerSpace.service;

import com.alibaba.fastjson.JSONObject;
import com.qks.makerSpace.exception.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FormService {

    Map<String, Object> setTechnologyForm(
            String token,
            String map,
            MultipartFile mediumFile,
            MultipartFile highEnterpriseFile,
            MultipartFile headerFile,
            MultipartFile[] contractFile,
            MultipartFile[] awardsFile) throws ServiceException, IOException;
    Map<String, Object> getDownLoadForm(String creditCode) throws IllegalAccessException;
    void downLoadWord(HttpServletResponse response, Map<String, Object> map) throws Exception;

    void spaceDownLoad(HttpServletResponse response, String inApplyId) throws ServiceException, IllegalAccessException;
}
