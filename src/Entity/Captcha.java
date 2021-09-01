package Entity;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Angel Ponce
 */
public class Captcha {

    private String token;
    private ImageIcon captcha;
    private static final Random R = new Random();
    //<editor-fold defaultstate="collapsed" desc="captchas">
    public static final String[] CAPTCHAS = {"226md.png",
        "22d5n.png",
        "2356g.png",
        "23mdg.png",
        "23n88.png",
        "243mm.png",
        "244e2.png",
        "245y5.png",
        "24f6w.png",
        "24pew.png",
        "25257.png",
        "253dc.png",
        "25egp.png",
        "25m6p.png",
        "25p2m.png",
        "25w53.png",
        "264m5.png",
        "268g2.png",
        "28348.png",
        "28x47.png",
        "2b827.png",
        "2bg48.png",
        "2cegf.png",
        "2cg58.png",
        "2cgyx.png",
        "2en7g.png",
        "2enf4.png",
        "2fxgd.png",
        "2g783.png",
        "2g7nm.png",
        "2gyb6.png",
        "2mg87.png",
        "2mpnn.png",
        "2n73f.png",
        "2nbc5.jpg",
        "2nbcx.png",
        "2nf26.png",
        "2npg6.png",
        "2nx38.png",
        "2p2y8.png",
        "2pfpn.png",
        "2w4y7.png",
        "2wc38.png",
        "2wx73.png",
        "2x7bm.png",
        "2xc2n.png",
        "2ycn8.png",
        "2yggg.png",
        "325fb.png",
        "32cnn.png",
        "32dnn.png",
        "33b22.png",
        "33f7m.png",
        "33n73.png",
        "33ng4.png",
        "33p4e.png",
        "34b84.png",
        "34fxm.png",
        "34pcn.png",
        "368y5.png",
        "36bc2.png",
        "36nx4.png",
        "36w25.png",
        "373gb.png",
        "377xx.png",
        "378e5.png",
        "37d52.png",
        "37ep6.png",
        "387g2.png",
        "38n57.png",
        "3b4we.png",
        "3bd8f.png",
        "3bfnd.png",
        "3bnyf.png",
        "3bx86.png",
        "3c7de.jpg",
        "3cpwb.png",
        "3d7bd.png",
        "3den6.png",
        "3dgmf.png",
        "3ebnn.png",
        "3ebpw.png",
        "3eny7.png",
        "3fbxd.png",
        "3g2w6.png",
        "3mxdn.png",
        "3n2b4.png",
        "3n3cf.png",
        "3n7mx.png",
        "3ndxd.png",
        "3nfdn.png",
        "3nnpw.png",
        "3nw7w.png",
        "3ny45.png",
        "3p4nn.png",
        "3p67n.png",
        "3pe4g.png",
        "3w2bw.png",
        "3wnd3.png",
        "3x325.png",
        "3x5fm.png",
        "3xcgg.png",
        "3xng6.png",
        "3ye2e.png",
        "3ygde.png",
        "3ym7f.png",
        "428b6.png",
        "42dw4.png",
        "42nxy.png",
        "42xpy.png",
        "43gey.png",
        "43mn5.png",
        "43p5d.png",
        "43xfe.png",
        "4433m.png",
        "445cc.png",
        "44c22.png",
        "44fyb.png",
        "44xe8.png",
        "44ype.png",
        "467d5.png",
        "46mbm.png",
        "4743p.png",
        "474ff.png",
        "478nx.png",
        "47e4p.png",
        "47m2b.png",
        "488de.png",
        "4b2pw.png",
        "4c8n8.png",
        "4cfw8.png",
        "4cn7b.png",
        "4d22m.png",
        "4dgf7.png",
        "4dw3w.png",
        "4egem.png",
        "4exnn.png",
        "4f8yp.png",
        "4fc36.png",
        "4fp5g.png",
        "4gb3f.png",
        "4gycb.png",
        "4m2w5.png",
        "4n2yg.png",
        "4n3mn.png",
        "4nc37.png",
        "4nnf3.png",
        "4w6mw.png",
        "4w76g.png",
        "4yc85.png",
        "4ycex.png",
        "4ynf3.png",
        "52447.png",
        "5325m.png",
        "537nf.png",
        "53mn8.png",
        "53wb8.png",
        "53wp3.png",
        "556wd.png",
        "55w5c.png",
        "55y2m.png",
        "56c34.png",
        "56m6y.png",
        "56ncx.png",
        "573bn.png",
        "573d8.png",
        "574d7.png",
        "57b27.png",
        "57gnx.png",
        "57wdp.png",
        "58b5m.png",
        "58pnp.png",
        "5bb66.png",
        "5bg8f.png",
        "5bgp2.png",
        "5bnd7.png",
        "5dxnm.png",
        "5ep3n.png",
        "5expp.png",
        "5f3gf.png",
        "5fyem.png",
        "5g5e5.png",
        "5gcd3.png",
        "5mcy7.png",
        "5mf7c.png",
        "5mfff.png",
        "5mgn4.png",
        "5mnpd.png",
        "5n245.png",
        "5n3w4.png",
        "5n728.png",
        "5n732.png",
        "5ng6e.png",
        "5nggg.png",
        "5nm6d.png",
        "5nnff.png",
        "5np4m.png",
        "5npdn.png",
        "5nxnn.png",
        "5p3mm.png",
        "5p8fm.png",
        "5pm6b.png",
        "5wddw.png",
        "5x5nx.png",
        "5x7x5.png",
        "5xd2e.png",
        "5xwcg.png",
        "5ywwf.png",
        "5yxgp.png",
        "62fgn.jpg",
        "62nb3.png",
        "63824.png",
        "63pxe.png",
        "646x8.png",
        "64b3p.png",
        "64m82.png",
        "658xe.png",
        "65ebm.png",
        "65m85.png",
        "65nmw.jpg",
        "662bw.png",
        "664dn.png",
        "664nf.png",
        "66wp5.png",
        "675p3.png",
        "677g3.png",
        "678w3.png",
        "67dey.png",
        "6825y.png",
        "68wfd.png",
        "68x48.png",
        "6b46g.png",
        "6b4w6.png",
        "6bdn5.png",
        "6bnnm.png",
        "6bxwg.png",
        "6c3n6.png",
        "6c3p5.png",
        "6cm6m.png",
        "6cwxe.png",
        "6dd2y.png",
        "6dmx7.png",
        "6e2dg.png",
        "6e554.png",
        "6e6pn.png",
        "6ecbn.png",
        "6end3.png",
        "6f2yc.png",
        "6f857.png",
        "6fg8c.png",
        "6fgdw.png",
        "6fn84.png",
        "6g45w.png",
        "6ge3p.png",
        "6gnm3.png",
        "6m5eg.png",
        "6mege.png",
        "6mn8n.png",
        "6mygb.png",
        "6n443.png",
        "6n5fd.png",
        "6n6gg.png",
        "6ng6n.png",
        "6ng6w.png",
        "6p2ge.png",
        "6p7gx.png",
        "6pfy4.png",
        "6pwcn.png",
        "6wb76.png",
        "6wg4n.png",
        "6wnyc.png",
        "6xen4.png",
        "6xpme.png",
        "6xxdx.png",
        "6ydyp.png",
        "728n8.png",
        "72m6f.png",
        "73mnx.png",
        "74853.png",
        "74eyg.png",
        "75pfw.png",
        "7634y.png",
        "76353.png",
        "76n7p.png",
        "76nxn.png",
        "76y6f.png",
        "77387.png",
        "77n6g.png",
        "77wp4.png",
        "785n4.png",
        "78dw6.jpg",
        "78eec.png",
        "7b4bm.png",
        "7bb7b.png",
        "7bwm2.png",
        "7cdge.png",
        "7cgym.png",
        "7d44m.png",
        "7dgc2.png",
        "7dwx4.png",
        "7dxbd.png",
        "7dyww.png",
        "7e2y7.png",
        "7f8b3.png",
        "7fde7.png",
        "7fmcy.png",
        "7g3nf.png",
        "7gce6.png",
        "7gmf3.png",
        "7gnge.png",
        "7gp47.png",
        "7m8px.png",
        "7mgmf.png",
        "7nnnx.png",
        "7p852.png",
        "7pcd7.png",
        "7pn5g.png",
        "7w67m.png",
        "7wn74.png",
        "7wnpm.png",
        "7wyp4.png",
        "7xcyd.png",
        "7xd5m.png",
        "7y2x4.png",
        "7yf62.png",
        "823p2.png",
        "82fx2.png",
        "832f3.png",
        "84py4.jpg",
        "84w7x.png",
        "85622.png",
        "85dxn.png",
        "85pew.jpg",
        "865wm.png",
        "8684m.png",
        "87d4c.png",
        "87nym.png",
        "88bgx.png",
        "88y52.png",
        "8b735.png",
        "8bbm4.png",
        "8bbw8.png",
        "8c23f.png",
        "8c2wy.png",
        "8cccc.png",
        "8cm46.png",
        "8d2nd.png",
        "8d4wm.png",
        "8d8ep.png",
        "8db67.png",
        "8e32m.png",
        "8eggg.png",
        "8fexn.png",
        "8g4yp.png",
        "8gecm.png",
        "8gf7n.png",
        "8gmc4.png",
        "8gmnx.png",
        "8n2pg.png",
        "8n34n.png",
        "8n4n8.png",
        "8n56m.png",
        "8n5p3.png",
        "8n5pn.png",
        "8n62n.png",
        "8n65n.png",
        "8nbew.png",
        "8ne4g.png",
        "8nn73.png",
        "8np22.png",
        "8npd5.png",
        "8npe3.png",
        "8pfxx.png",
        "8w754.png",
        "8w875.png",
        "8wy7d.png",
        "8xef7.png",
        "8y63f.png",
        "8y6b3.png",
        "8ypdn.png",
        "b26nd.png",
        "b28g8.png",
        "b2g8e.png",
        "b2nen.png",
        "b35f6.png",
        "b3xpn.png",
        "b43nw.png",
        "b4d7c.png",
        "b4ncn.png",
        "b4ndb.jpg",
        "b4y5x.png",
        "b55d6.png",
        "b5dn4.png",
        "b5fm7.png",
        "b5nmm.png",
        "b5pnn.png",
        "b685n.png",
        "b6f2p.png",
        "b84xc.png",
        "bbymy.png",
        "bc8nf.png",
        "bcwnn.png",
        "bd3b7.png",
        "bdbb3.png",
        "bdg84.png",
        "be3bp.png",
        "be6np.png",
        "befbd.png",
        "bf52c.png",
        "bgb48.png",
        "bgd4m.png",
        "bgem5.png",
        "bgxcd.jpg",
        "bm3p8.png",
        "bmxpe.png",
        "bn5mw.png",
        "bnc2f.png",
        "bnc5f.png",
        "bny23.png",
        "bny4w.png",
        "bp2d4.png",
        "bp6mw.png",
        "bpwd7.png",
        "bw44w.png",
        "bw5nf.png",
        "bw5ym.png",
        "bw6n6.png",
        "bwmee.png",
        "bx5ed.jpg",
        "bxxfc.png",
        "by5y3.png",
        "byc82.png",
        "byfgn.png",
        "c2fb7.png",
        "c2g4d.png",
        "c2pg6.png",
        "c2yn8.png",
        "c353e.png",
        "c3572.png",
        "c3n8x.png",
        "c43b4.png",
        "c4527.png",
        "c482b.png",
        "c4bgd.png",
        "c4bny.png",
        "c4mcm.png",
        "c55c6.png",
        "c5xne.png",
        "c6745.png",
        "c6f8g.png",
        "c6we6.png",
        "c753e.png",
        "c7gb3.png",
        "c7nn8.png",
        "c86md.png",
        "c8fxy.png",
        "c8n8c.png",
        "cb8cf.png",
        "cc845.png",
        "ccf2w.png",
        "ccn2x.png",
        "cd4eg.png",
        "cd6p4.png",
        "cdcb3.png",
        "cdf77.png",
        "cdfen.png",
        "cdmn8.png",
        "cen55.png",
        "cewnm.png",
        "cfc2y.png",
        "cfc56.png",
        "cffp4.png",
        "cfn53.png",
        "cfp86.png",
        "cfw6e.png",
        "cg5dd.png",
        "cgcgb.png",
        "cm6yb.png",
        "cndmc.jpg",
        "cnex4.png",
        "cnmnn.png",
        "cnwyc.png",
        "cpc8c.png",
        "cpe63.png",
        "cwdnx.png",
        "cwgyx.png",
        "cwmny.png",
        "cx3wg.png",
        "cy3nw.png",
        "d22bd.png",
        "d22n7.png",
        "d22y5.png",
        "d236n.png",
        "d2n8x.jpg",
        "d2nbn.png",
        "d2ycw.png",
        "d378n.png",
        "d3c7y.png",
        "d3c8y.png",
        "d3ycn.png",
        "d4n82.png",
        "d4ppy.png",
        "d666m.png",
        "d66cn.png",
        "d6fcn.png",
        "d75b5.png",
        "d7c5x.png",
        "d7en3.png",
        "d7nn3.png",
        "d8dce.png",
        "d8xcn.png",
        "dbex3.png",
        "dbfen.png",
        "dbny3.png",
        "dbpcd.png",
        "dc436.png",
        "dce8y.png",
        "dcnp8.png",
        "dd5w5.png",
        "dd764.png",
        "ddcdd.png",
        "ddcne.png",
        "ddmyg.png",
        "ddnpf.png",
        "ddpyb.png",
        "ddxpp.jpg",
        "de45x.png",
        "de7f8.png",
        "deep5.png",
        "defyx.png",
        "deneb.png",
        "dfnx4.png",
        "dgcm4.jpg",
        "dmw8n.png",
        "dmx8p.png",
        "dmxp8.png",
        "dn26n.png",
        "dn2ym.png",
        "dn5df.png",
        "dnmd8.png",
        "dnne7.png",
        "dnxdp.png",
        "dpbyd.png",
        "dw3nn.png",
        "dw6mn.png",
        "dw8d3.png",
        "dxwcw.png",
        "dy3cx.png",
        "dyp7n.png",
        "dyxnc.png",
        "e25xg.png",
        "e2d66.png",
        "e2mg2.png",
        "e3cfe.jpg",
        "e3ndn.png",
        "e43ym.png",
        "e46pd.png",
        "e46yw.png",
        "e4gd7.png",
        "e5n66.png",
        "e667x.png",
        "e6b7y.png",
        "e6m6p.png",
        "e72cd.png",
        "e76n4.png",
        "e7nx4.png",
        "e7x45.png",
        "e84n2.png",
        "e8dxn.png",
        "e8e5e.png",
        "ebcbx.png",
        "ec6pm.png",
        "ecd4w.png",
        "edg3p.png",
        "edwny.png",
        "ee8fg.png",
        "een23.png",
        "ef4mn.png",
        "ef4np.png",
        "efb3f.png",
        "efe62.png",
        "efg72.png",
        "efgx5.png",
        "efx34.png",
        "egxmp.png",
        "emwpn.png",
        "en32e.png",
        "en4n4.png",
        "eng53.png",
        "enn7n.png",
        "ennmm.png",
        "enpw2.png",
        "ep85x.png",
        "eppg3.png",
        "ewcf5.png",
        "ewnx8.png",
        "ewyg7.jpg",
        "excmn.png",
        "exycn.png",
        "f228n.png",
        "f22bn.png",
        "f2fge.png",
        "f2m8n.png",
        "f35xp.png",
        "f364x.png",
        "f4fn2.png",
        "f4wfn.png",
        "f5cm2.png",
        "f5e5e.png",
        "f6bpw.jpg",
        "f6ne5.png",
        "f6ww8.png",
        "f74x3.png",
        "f753f.png",
        "f75cx.png",
        "f7cey.png",
        "f83pn.png",
        "f858x.png",
        "f85y3.png",
        "f8f8g.png",
        "fbp2c.png",
        "fc2ff.png",
        "fc6xb.png",
        "fcey3.png",
        "fcmem.png",
        "fcne6.png",
        "fdpgd.png",
        "feyc8.png",
        "ffd6p.png",
        "ffnxn.png",
        "ffpxf.png",
        "fg38b.png",
        "fg7mg.png",
        "fg8n4.png",
        "fgb36.jpg",
        "fnbfw.png",
        "fncnb.png",
        "fp382.png",
        "fp3wy.png",
        "fp5wn.png",
        "fp762.png",
        "fpw76.png",
        "fw3b2.png",
        "fwxdp.png",
        "fxpw3.png",
        "fy2nd.png",
        "fyfbn.png",
        "fywb8.png",
        "g247w.png",
        "g2577.png",
        "g2fnw.png",
        "g3dy6.png",
        "g3ex3.png",
        "g55b4.png",
        "g6n7x.png",
        "g78gn.png",
        "g7fmc.png",
        "g7gnf.png",
        "g7wxw.png",
        "g842c.png",
        "g888x.png",
        "g8gnd.png",
        "gbxyy.png",
        "gc277.png",
        "gc2wd.png",
        "gc83b.png",
        "gcfgp.png",
        "gcx6f.png",
        "gd4mf.png",
        "gd8fb.png",
        "gdng3.png",
        "gecmf.png",
        "gegw4.png",
        "gewfy.png",
        "geyn5.jpg",
        "gf2g4.png",
        "gfbx6.png",
        "gfp54.png",
        "gfxcc.png",
        "ggd7m.png",
        "gm2c2.png",
        "gm6nn.png",
        "gm7n8.png",
        "gmmne.jpg",
        "gn2d3.png",
        "gn2xy.png",
        "gnbde.png",
        "gnbn4.png",
        "gnc3n.png",
        "gnf85.png",
        "gng6e.png",
        "gny6b.png",
        "gp22x.png",
        "gp7c5.png",
        "gpnxn.png",
        "gpxng.png",
        "gw468.png",
        "gw53m.png",
        "gwn53.png",
        "gwnm6.png",
        "gxx2p.png",
        "gxxpf.png",
        "gy433.png",
        "gy5bf.png",
        "gy8xb.png",
        "gymmn.png",
        "m22e3.png",
        "m23bp.png",
        "m2576.png",
        "m2nf4.png",
        "m3588.png",
        "m3b5p.png",
        "m3wfw.png",
        "m448b.png",
        "m457d.png",
        "m4fd8.png",
        "m4g8g.png",
        "m5meg.png",
        "m5ym2.png",
        "m67b3.png",
        "m6n4x.png",
        "m74dm.png",
        "m75bf.png",
        "m8gmx.png",
        "m8m4x.png",
        "mb4en.png",
        "mbf58.png",
        "mbp2y.png",
        "mc35n.png",
        "mc8w2.png",
        "mcc2x.png",
        "mcg43.png",
        "mcyfx.png",
        "md344.png",
        "mddgb.png",
        "mdxpn.png",
        "mdyp7.png",
        "men4f.png",
        "mfb3x.png",
        "mfc35.png",
        "mg5nn.png",
        "mgdwb.png",
        "mggce.png",
        "mgw3n.png",
        "mm3nn.png",
        "mmc5n.png",
        "mmfm6.png",
        "mmg2m.png",
        "mmg38.png",
        "mmy5n.png",
        "mn5c4.png",
        "mnef5.png",
        "mp7wp.png",
        "mpmy5.png",
        "mpxfb.png",
        "mw5p2.png",
        "mwdf6.png",
        "mwxwp.png",
        "mx8bb.png",
        "mxnw4.png",
        "mxyxw.png",
        "my84e.png",
        "myc3c.png",
        "mye68.png",
        "myf82.png",
        "n265y.png",
        "n2by7.png",
        "n2c85.jpg",
        "n2gmg.png",
        "n336e.png",
        "n373n.png",
        "n3bm6.png",
        "n3ffn.png",
        "n3m6x.png",
        "n3x4c.png",
        "n3xfg.jpg",
        "n464c.png",
        "n4b4m.png",
        "n4cpy.png",
        "n4wwn.png",
        "n4xx5.png",
        "n5cm7.png",
        "n5n8b.png",
        "n5w5g.png",
        "n5wbg.png",
        "n5x2n.png",
        "n6f4b.png",
        "n6nn2.png",
        "n6xc5.png",
        "n7dyb.png",
        "n7ebx.png",
        "n7enn.png",
        "n7ff2.png",
        "n7g4f.png",
        "n7meb.png",
        "n8fp6.png",
        "n8pfe.png",
        "n8wxm.jpg",
        "n8ydd.png",
        "nb267.png",
        "nb45d.png",
        "nbcgb.png",
        "nbf8m.png",
        "nbfx5.png",
        "nbmx7.png",
        "nbp3e.png",
        "nbwnn.png",
        "nbwpn.png",
        "nc4yg.png",
        "ncfgb.png",
        "ncw4g.png",
        "ncww7.png",
        "ncyx8.png",
        "nd5wg.png",
        "ndecc.png",
        "ndg2b.png",
        "ndme7.png",
        "ndyfe.png",
        "ne325.png",
        "neecd.png",
        "neggn.png",
        "nf2n8.png",
        "nf7bn.png",
        "nf8b8.png",
        "nfbg8.png",
        "nfcb5.png",
        "nfcwy.png",
        "nfd8g.png",
        "nfg23.png",
        "nfndw.png",
        "ng2gw.png",
        "ng46m.png",
        "ng6yp.png",
        "ng756.png",
        "ngn26.png",
        "nm248.png",
        "nm46n.png",
        "nmw46.png",
        "nmy2x.png",
        "nn4wx.png",
        "nn6mg.png",
        "nn6w6.jpg",
        "nnf8b.png",
        "nnfx3.png",
        "nngxc.png",
        "nnn57.png",
        "nnn5p.png",
        "nnp4e.png",
        "nny5e.png",
        "npxb7.png",
        "nw5b2.png",
        "nwfde.png",
        "nwg2m.png",
        "nwncn.png",
        "nxc83.png",
        "nxcmn.png",
        "nxf2c.jpg",
        "nxn4f.png",
        "nxx25.png",
        "nxxf8.png",
        "ny3dw.png",
        "ny3nn.png",
        "ny5dp.png",
        "ny8np.png",
        "nybcx.png",
        "p24gn.png",
        "p2dw7.png",
        "p2m6n.png",
        "p2x7x.png",
        "p2ym2.png",
        "p4nm4.png",
        "p4pde.png",
        "p57fn.png",
        "p5g5m.png",
        "p5nce.png",
        "p6mn8.png",
        "p7fyp.png",
        "p8c24.png",
        "p8ngx.png",
        "p8wwf.png",
        "pbpgc.png",
        "pcede.png",
        "pcm7f.png",
        "pcmcc.jpg",
        "pcpg6.png",
        "pdcp4.png",
        "pdw38.png",
        "pdyc8.png",
        "pe4xn.png",
        "pf4nb.png",
        "pf5ng.png",
        "pg2pm.png",
        "pg2yx.png",
        "pg4bf.png",
        "pgg3n.png",
        "pgm2e.png",
        "pgmn2.png",
        "pgwnp.png",
        "pm363.png",
        "pm47f.png",
        "pmd3w.png",
        "pme86.png",
        "pmf5w.png",
        "pmg55.png",
        "pn7pn.png",
        "pnmxf.png",
        "pnnwy.png",
        "pp546.png",
        "pp87n.png",
        "ppwyd.png",
        "ppx77.png",
        "pw5nc.png",
        "pwebm.png",
        "pwmbn.png",
        "pwn5e.png",
        "px2xp.png",
        "px8n8.png",
        "pxdwp.png",
        "pxne8.png",
        "pybee.png",
        "pyefb.png",
        "pyf65.png",
        "pym7p.png",
        "w2e87.png",
        "w2n7e.png",
        "w2yp7.png",
        "w46ep.png",
        "w48cw.png",
        "w4cdc.png",
        "w4cnn.png",
        "w4nfx.png",
        "w4x2m.png",
        "w52fn.png",
        "w6ny4.jpg",
        "w6pxy.png",
        "w6yne.png",
        "w75w8.png",
        "w7e6m.png",
        "w8bnx.png",
        "w8f36.png",
        "wb3ed.png",
        "wbncw.png",
        "wc2bd.png",
        "wce5n.png",
        "wd2gb.png",
        "wddcp.png",
        "wdww8.png",
        "wecfd.png",
        "wf684.png",
        "wfy5m.png",
        "wg625.png",
        "wgnwp.png",
        "wm47f.png",
        "wm746.png",
        "wmpmp.png",
        "wnmyn.png",
        "wnpec.png",
        "wwmn6.png",
        "wxcn8.png",
        "wxy4n.png",
        "wyc25.png",
        "wye85.png",
        "x277e.png",
        "x2cnn.png",
        "x347n.png",
        "x362g.png",
        "x37bf.png",
        "x38fn.png",
        "x3deb.png",
        "x3fwf.png",
        "x44n4.png",
        "x458w.png",
        "x4f7g.png",
        "x4gg5.png",
        "x4pnp.png",
        "x5f54.png",
        "x5nyn.png",
        "x6b5m.png",
        "x6pdb.png",
        "x7422.png",
        "x74b2.png",
        "x7547.png",
        "x76mn.png",
        "x7746.png",
        "x775w.png",
        "x8e8n.png",
        "x8xnp.png",
        "xbcbx.png",
        "xbem6.png",
        "xc68n.png",
        "xce8d.png",
        "xcf88.png",
        "xcmbp.png",
        "xdcn4.png",
        "xdn65.png",
        "xe6eb.png",
        "xe8xm.png",
        "xemyg.png",
        "xf4p4.png",
        "xf5g7.png",
        "xfg65.png",
        "xfgxb.png",
        "xfn6n.png",
        "xgcxy.png",
        "xmcym.png",
        "xnd3y.png",
        "xnfx5.png",
        "xngxc.png",
        "xnn4d.png",
        "xnnc3.png",
        "xp24p.png",
        "xw465.png",
        "xwx7d.png",
        "xxbm5.png",
        "xxney.png",
        "xxw44.png",
        "xymfn.png",
        "xyncc.png",
        "xyyyw.png",
        "y2436.png",
        "y2xg4.png",
        "y2ye8.png",
        "y32yy.png",
        "y33nm.png",
        "y3c58.png",
        "y48c3.png",
        "y4ec2.png",
        "y4g3b.png",
        "y4n6m.png",
        "y53c2.png",
        "y5dpp.png",
        "y5g87.png",
        "y5n6d.png",
        "y5w28.png",
        "y7d75.png",
        "y7mnm.png",
        "y7x8p.png",
        "y866y.png",
        "ybfx6.png",
        "ycmcw.png",
        "ycnfc.png",
        "yd38e.png",
        "yd3m3.png",
        "yd755.png",
        "ydd3g.png",
        "ydg8n.png",
        "yemy4.png",
        "yew6p.png",
        "yeyn4.png",
        "yf28d.png",
        "yf347.png",
        "yf424.png",
        "yfdn7.png",
        "yg5bb.png",
        "ygce8.jpg",
        "yge7c.jpg",
        "ygenn.png",
        "ygfwe.png",
        "ymp7g.png",
        "ypp8f.png",
        "ypw3d.png",
        "yw667.png",
        "yw7ny.png",
        "yw8y5.jpg",
        "ywn6f.png",
        "yx2d4.png",
        "yxd7m.png",
        "yy824.png",
        "yyg5g.png",
        "yyn57.png"};
//</editor-fold>

    public Captcha() {
        int random = R.nextInt(CAPTCHAS.length);
        String captchatoken = CAPTCHAS[random];
        this.token = captchatoken.replaceAll("\\..*", "");
        this.captcha = new ImageIcon(getClass().getResource("/Resources/captcha/" + captchatoken));
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean validate(String token) {
        return this.token.equals(token);
    }

    public ImageIcon getCaptcha() {
        return captcha;
    }

    public void setCaptcha(ImageIcon captcha) {
        this.captcha = captcha;
    }

}
