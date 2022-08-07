package com.jpostest.isoserver;

import org.jpos.iso.*;
import org.jpos.iso.channel.XMLChannel;
import org.jpos.iso.packager.XMLPackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

import java.io.IOException;

//Test iso channel
public class IsoServerTest implements ISORequestListener
{
    @Override
    public boolean process(ISOSource source, ISOMsg m)
    {
        try {
            m.setResponseMTI();
            m.set(39, "00");
            source.send(m);
        }
        catch ( ISOException |IOException e ) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static void main(String[] args) throws ISOException, IOException
    {
        Logger logger = new Logger();
        logger.addListener(new SimpleLogListener(System.out));
        ServerChannel channel = new XMLChannel(new XMLPackager());
        ((LogSource)channel).setLogger(logger, "channel");
        ISOServer server = new ISOServer(8000, channel, null);
        server.setLogger(logger, "server");
        server.addISORequestListener(new IsoServerTest());
        new Thread(server).start();
    }
}
