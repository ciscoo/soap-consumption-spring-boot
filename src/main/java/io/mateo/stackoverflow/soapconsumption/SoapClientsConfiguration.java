package io.mateo.stackoverflow.soapconsumption;

import com.xignite.services.XigniteCurrenciesSoap;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapClientsConfiguration {
    @Bean
    public XigniteCurrenciesSoap xigniteCurrenciesSoap() {
        return createSoapClient(XigniteCurrenciesSoap.class, "http://www.xignite.com/xcurrencies.asmx");
    }

    private <T> T createSoapClient(Class<T> clazz, String address) {
        JaxWsClientFactoryBean jaxWsClientFactoryBean = new JaxWsClientFactoryBean();
        jaxWsClientFactoryBean.setAddress(address);
        jaxWsClientFactoryBean.setServiceClass(clazz);
        //noinspection unchecked
        return (T) jaxWsClientFactoryBean.create();
    }
}
