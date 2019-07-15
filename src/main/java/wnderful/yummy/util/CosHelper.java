package wnderful.yummy.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Component
public class CosHelper {
    private COSClient cosClient;
    private String bucketName;
    private String beforeURL;

    public CosHelper() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        COSCredentials cred = new BasicCOSCredentials("AKIDtcBh1AEmEYidxqxlua580GqHk05xA8Za", "99ziCfxzynZ9XihRv40kW8UknbGgq692");
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
        // 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        bucketName = "picture-1257651089";
        beforeURL = "https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy";
    }


    public String getURL(String folder,String name,String fileName) {
        return beforeURL+"/"+folder+"/"+name+"-"+fileName;
    }

    public String getDefaultAvatarUrl(){
        return "https://picture-1257651089.cos.ap-shanghai.myqcloud.com/yummy/avatar/default.jfif ";
    }

    public void cosUpload(String folder, String name, MultipartFile file) throws IOException {

        String key = "yummy/"+folder + "/" + name + "-" + file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();

        ObjectMetadata objectMetadata = new ObjectMetadata();
        // 从输入流上传必须制定 content length, 否则 http 客户端可能会缓存所有数据，存在内存OOM的情况
        objectMetadata.setContentLength(inputStream.available());
        // 设置 contenttype 默认下载时根据 cos 路径 key 的后缀返回响应的 contenttype, 上传时设置 contenttype 会覆盖默认值
        objectMetadata.setContentType("image/jpeg");

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, objectMetadata);
        //设置存储类型：标准存储（Standard）， 低频存储存储（Standard_IA），归档存储（ARCHIVE）。默认是标准（Standard）
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);

        try {
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            // putobjectResult会返回文件的etag
            String eTag = putObjectResult.getETag();
            System.out.println("picture upload successfully! ETag:" + eTag);
        } catch (CosServiceException e) {
            e.printStackTrace();
        }
    }
}
