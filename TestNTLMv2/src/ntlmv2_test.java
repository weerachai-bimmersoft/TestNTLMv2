
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
public class ntlmv2_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("YGYYTTY");
        var credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new NTCredentials("username", "password", "", "someDomain"));
        try (
        	var client = HttpClients.custom()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
        ) {
        	System.out.println(client.toString());
            		var requestFactory = new HttpComponentsClientHttpRequestFactory();
            		requestFactory.setHttpClient(client);
            		RestTemplate restTemplate = new RestTemplate(requestFactory);
            		ResponseEntity<String> stringResponseEntity = 
            				restTemplate.postForEntity("url", new HttpEntity<>("yourDtoObject"), String.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
