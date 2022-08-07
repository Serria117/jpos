package com.jpostest.isoserver;

import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.q2.iso.QMUX;

public class Customizer
{
    private ISO87APackager packager;
    private ASCIIChannel channel;
    private QMUX mux = new QMUX();
}
