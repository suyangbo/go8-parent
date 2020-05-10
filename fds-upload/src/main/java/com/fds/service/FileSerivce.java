package com.fds.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

@Service
public class FileSerivce {
    @Value("${fdfs.proxyServer}")
    private String proxyServer;

    @Autowired
    private FastFileStorageClient client;

    public String upload(InputStream input, long l, String ext) {
        StorePath uploadFile = client.uploadFile(input, l, ext, null);
        return proxyServer + uploadFile.getPath();
    }
}
