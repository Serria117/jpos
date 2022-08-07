package com.jpostest;

import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOField;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.q2.Q2;
import org.jpos.q2.iso.QMUX;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JposApplication implements CommandLineRunner
{

    public static void main(String[] args)
    {
        SpringApplication.run(JposApplication.class, args);
    }

    @Bean
    public ISOMsg isoMsg()
    {
        return new ISOMsg();
    }

    @Override
    public void run(String... args) throws Exception
    {
        Q2 q2 = new Q2();
        Thread thread = new Thread(q2);
        thread.start();
//        Logger logger = new Logger();
//        logger.addListener(new SimpleLogListener(System.out));
//        ISOChannel channel = new ASCIIChannel(
//                "localhost", 8000, new ISO87APackager()
//        );
//        ((LogSource) channel).setLogger(logger, "test-channel");
//
//        try {
//            channel.connect();
//            ISOMsg m = new ISOMsg();
//            m.setMTI("0800");
//            m.set(3, "000000");
//            m.set(41, "00000001");
//            m.set(70, "301");
//            System.out.println("SEND:" + m);
//            channel.send(m);
//            ISOMsg r = channel.receive();
//
//            System.out.println("RECEIVE: " + r);
//
//            channel.disconnect();
//        }
//        catch ( Exception e ) {
//            System.out.println(e.getMessage());
//        }
    }
}
