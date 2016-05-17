package com.woong.android.tapmuse;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Woong on 2016-04-08.
 */
public class Music {
    //private long[] arr= new long[]{250, 500, 750, 1000, 1250, 1500, 1750, 2000};
    private List<Rythme> arr = new ArrayList<Rythme>();
    Context context;
    private long lastTiming;

    public Music(Context context) throws IOException {
        this.context = context;
/*            FileInputStream fis = new FileInputStream("");
            Scanner fscan = new Scanner(fis);
            while(fscan.hasNext()){
                arr.add(new Rythme(fscan.nextLong(), fscan.nextInt()));
            }
            fscan.close();
            fis.close();*/
        makeSong();
        lastTiming=arr.get(arr.size()-1).getTime();

    }

    public Tablet item(int num, int location) {
        //return new Tablet(context, arr.get(num).getLocation());
        return new Tablet(context, location);
    }

    public long getTiming(int num) {
        return arr.get(num).getTime();
    }

    public int getLocation(int num) {
        return arr.get(num).getLocation();
    }

    public int size() {
        return arr.size();
    }

    public long getLastTiming() {
        return lastTiming;
    }

    public void makeSong() {
        arr.add(new Rythme(250, 1));
        arr.add(new Rythme(500, 2));
        arr.add(new Rythme(750, 4));
        arr.add(new Rythme(1000, 8));
        arr.add(new Rythme(1250, 16));
        arr.add(new Rythme(1500, 4));
        arr.add(new Rythme(1750, 8));
        arr.add(new Rythme(2000, 16));
        arr.add(new Rythme(2250, 1));
        arr.add(new Rythme(2500, 2));
        arr.add(new Rythme(2750, 4));
        arr.add(new Rythme(3000, 8));
        arr.add(new Rythme(3250, 16));
        arr.add(new Rythme(3500, 4));
        arr.add(new Rythme(3750, 8));
        arr.add(new Rythme(4000, 16));
        arr.add(new Rythme(4250, 1));
        arr.add(new Rythme(4500, 2));
        arr.add(new Rythme(4750, 4));
        arr.add(new Rythme(5000, 8));
        arr.add(new Rythme(5250, 16));
        arr.add(new Rythme(5500, 4));
        arr.add(new Rythme(5750, 8));
        arr.add(new Rythme(6000, 16));
        arr.add(new Rythme(6250, 1));
        arr.add(new Rythme(6500, 2));
        arr.add(new Rythme(6750, 4));
        arr.add(new Rythme(7000, 8));
        arr.add(new Rythme(7250, 16));
        arr.add(new Rythme(7500, 4));
        arr.add(new Rythme(7750, 8));
        arr.add(new Rythme(8000, 16));
        arr.add(new Rythme(8250, 1));
        arr.add(new Rythme(8500, 2));
        arr.add(new Rythme(8750, 4));
        arr.add(new Rythme(9000, 8));
        arr.add(new Rythme(9250, 16));
        arr.add(new Rythme(9500, 4));
        arr.add(new Rythme(9750, 8));
        arr.add(new Rythme(10000, 16));
        arr.add(new Rythme(10250, 1));
        arr.add(new Rythme(10500, 2));
        arr.add(new Rythme(10750, 4));
        arr.add(new Rythme(11000, 8));
        arr.add(new Rythme(11250, 16));
        arr.add(new Rythme(11500, 4));
        arr.add(new Rythme(11750, 8));
        arr.add(new Rythme(12000, 16));
        arr.add(new Rythme(12250, 1));
        arr.add(new Rythme(12500, 2));
        arr.add(new Rythme(12750, 4));
        arr.add(new Rythme(13000, 8));
        arr.add(new Rythme(13250, 16));
        arr.add(new Rythme(13500, 4));
        arr.add(new Rythme(13750, 8));
        arr.add(new Rythme(14000, 16));
        arr.add(new Rythme(14250, 1));
        arr.add(new Rythme(14500, 2));
        arr.add(new Rythme(14750, 4));
        arr.add(new Rythme(15000, 8));
        arr.add(new Rythme(15250, 16));
        arr.add(new Rythme(15500, 4));
        arr.add(new Rythme(15750, 8));
        arr.add(new Rythme(16000, 16));
        arr.add(new Rythme(16250, 1));
        arr.add(new Rythme(16500, 2));
        arr.add(new Rythme(16750, 4));
        arr.add(new Rythme(17000, 8));
        arr.add(new Rythme(17250, 16));
        arr.add(new Rythme(17500, 4));
        arr.add(new Rythme(17750, 8));
        arr.add(new Rythme(18000, 16));
        arr.add(new Rythme(18250, 1));
        arr.add(new Rythme(18500, 2));
        arr.add(new Rythme(18750, 4));
        arr.add(new Rythme(19000, 8));
        arr.add(new Rythme(19250, 16));
        arr.add(new Rythme(19500, 4));
        arr.add(new Rythme(19750, 8));
        arr.add(new Rythme(20000, 16));
        arr.add(new Rythme(20250, 1));
        arr.add(new Rythme(20500, 2));
        arr.add(new Rythme(20750, 4));
        arr.add(new Rythme(21000, 8));
        arr.add(new Rythme(21250, 16));
        arr.add(new Rythme(21500, 4));
        arr.add(new Rythme(21750, 8));
        arr.add(new Rythme(22000, 16));
        arr.add(new Rythme(22250, 1));
        arr.add(new Rythme(22500, 2));
        arr.add(new Rythme(22750, 4));
        arr.add(new Rythme(23000, 8));
        arr.add(new Rythme(23250, 16));
        arr.add(new Rythme(23500, 4));
        arr.add(new Rythme(23750, 8));
        arr.add(new Rythme(24000, 16));
        arr.add(new Rythme(24250, 1));
        arr.add(new Rythme(24500, 2));
        arr.add(new Rythme(24750, 4));
        arr.add(new Rythme(25000, 8));
        arr.add(new Rythme(25250, 16));
        arr.add(new Rythme(25500, 4));
        arr.add(new Rythme(25750, 8));
        arr.add(new Rythme(26000, 16));
        arr.add(new Rythme(26250, 1));
        arr.add(new Rythme(26500, 2));
        arr.add(new Rythme(26750, 4));
        arr.add(new Rythme(27000, 8));
        arr.add(new Rythme(27250, 16));
        arr.add(new Rythme(27500, 4));
        arr.add(new Rythme(27750, 8));
        arr.add(new Rythme(28000, 16));
        arr.add(new Rythme(28250, 1));
        arr.add(new Rythme(28500, 2));
        arr.add(new Rythme(28750, 4));
        arr.add(new Rythme(29000, 8));
        arr.add(new Rythme(29250, 16));
        arr.add(new Rythme(29500, 4));
        arr.add(new Rythme(29750, 8));
        arr.add(new Rythme(30000, 16));
        arr.add(new Rythme(30250, 1));
        arr.add(new Rythme(30500, 2));
        arr.add(new Rythme(30750, 4));
        arr.add(new Rythme(31000, 8));
        arr.add(new Rythme(31250, 16));
        arr.add(new Rythme(31500, 4));
        arr.add(new Rythme(31750, 8));
        arr.add(new Rythme(32000, 16));
        arr.add(new Rythme(32250, 1));
        arr.add(new Rythme(32500, 2));
        arr.add(new Rythme(32750, 4));
        arr.add(new Rythme(33000, 8));
        arr.add(new Rythme(33250, 16));
        arr.add(new Rythme(33500, 4));
        arr.add(new Rythme(33750, 8));
        arr.add(new Rythme(34000, 16));
        arr.add(new Rythme(34250, 1));
        arr.add(new Rythme(34500, 2));
        arr.add(new Rythme(34750, 4));
        arr.add(new Rythme(35000, 8));
        arr.add(new Rythme(35250, 16));
        arr.add(new Rythme(35500, 4));
        arr.add(new Rythme(35750, 8));
        arr.add(new Rythme(36000, 16));
        arr.add(new Rythme(36250, 1));
        arr.add(new Rythme(36500, 2));
        arr.add(new Rythme(36750, 4));
        arr.add(new Rythme(37000, 8));
        arr.add(new Rythme(37250, 16));
        arr.add(new Rythme(37500, 4));
        arr.add(new Rythme(37750, 8));
        arr.add(new Rythme(38000, 16));
        arr.add(new Rythme(38250, 1));
        arr.add(new Rythme(38500, 2));
        arr.add(new Rythme(38750, 4));
        arr.add(new Rythme(39000, 8));
        arr.add(new Rythme(39250, 16));
        arr.add(new Rythme(39500, 4));
        arr.add(new Rythme(39750, 8));
        arr.add(new Rythme(40000, 16));
        arr.add(new Rythme(40250, 1));
        arr.add(new Rythme(40500, 2));
        arr.add(new Rythme(40750, 4));
        arr.add(new Rythme(41000, 8));
        arr.add(new Rythme(41250, 16));
        arr.add(new Rythme(41500, 4));
        arr.add(new Rythme(41750, 8));
        arr.add(new Rythme(42000, 16));
        arr.add(new Rythme(42250, 1));
        arr.add(new Rythme(42500, 2));
        arr.add(new Rythme(42750, 4));
        arr.add(new Rythme(43000, 8));
        arr.add(new Rythme(43250, 16));
        arr.add(new Rythme(43500, 4));
        arr.add(new Rythme(43750, 8));
        arr.add(new Rythme(44000, 16));
        arr.add(new Rythme(44250, 1));
        arr.add(new Rythme(44500, 2));
        arr.add(new Rythme(44750, 4));
        arr.add(new Rythme(45000, 8));
        arr.add(new Rythme(45250, 16));
        arr.add(new Rythme(45500, 4));
        arr.add(new Rythme(45750, 8));
        arr.add(new Rythme(46000, 16));
        arr.add(new Rythme(46250, 1));
        arr.add(new Rythme(46500, 2));
        arr.add(new Rythme(46750, 4));
        arr.add(new Rythme(47000, 8));
        arr.add(new Rythme(47250, 16));
        arr.add(new Rythme(47500, 4));
        arr.add(new Rythme(47750, 8));
        arr.add(new Rythme(48000, 16));
        arr.add(new Rythme(48250, 1));
        arr.add(new Rythme(48500, 2));
        arr.add(new Rythme(48750, 4));
        arr.add(new Rythme(49000, 8));
        arr.add(new Rythme(49250, 16));
        arr.add(new Rythme(49500, 4));
        arr.add(new Rythme(49750, 8));
        arr.add(new Rythme(50000, 16));
        arr.add(new Rythme(50250, 1));
        arr.add(new Rythme(50500, 2));
        arr.add(new Rythme(50750, 4));
        arr.add(new Rythme(51000, 8));
        arr.add(new Rythme(51250, 16));
        arr.add(new Rythme(51500, 4));
        arr.add(new Rythme(51750, 8));
        arr.add(new Rythme(52000, 16));
        arr.add(new Rythme(52250, 1));
        arr.add(new Rythme(52500, 2));
        arr.add(new Rythme(52750, 4));
        arr.add(new Rythme(53000, 8));
        arr.add(new Rythme(53250, 16));
        arr.add(new Rythme(53500, 4));
        arr.add(new Rythme(53750, 8));
        arr.add(new Rythme(54000, 16));
        arr.add(new Rythme(54250, 1));
        arr.add(new Rythme(54500, 2));
        arr.add(new Rythme(54750, 4));
        arr.add(new Rythme(55000, 8));
        arr.add(new Rythme(55250, 16));
        arr.add(new Rythme(55500, 4));
        arr.add(new Rythme(55750, 8));
        arr.add(new Rythme(56000, 16));
        arr.add(new Rythme(56250, 1));
        arr.add(new Rythme(56500, 2));
        arr.add(new Rythme(56750, 4));
        arr.add(new Rythme(57000, 8));
        arr.add(new Rythme(57250, 16));
        arr.add(new Rythme(57500, 4));
        arr.add(new Rythme(57750, 8));
        arr.add(new Rythme(58000, 16));
        arr.add(new Rythme(58250, 1));
        arr.add(new Rythme(58500, 2));
        arr.add(new Rythme(58750, 4));
        arr.add(new Rythme(59000, 8));
        arr.add(new Rythme(59250, 16));
        arr.add(new Rythme(59500, 4));
        arr.add(new Rythme(59750, 8));
        arr.add(new Rythme(60000, 16));
        arr.add(new Rythme(60250, 1));
        arr.add(new Rythme(60500, 2));
        arr.add(new Rythme(60750, 4));
        arr.add(new Rythme(61000, 8));
        arr.add(new Rythme(61250, 16));
        arr.add(new Rythme(61500, 4));
        arr.add(new Rythme(61750, 8));
        arr.add(new Rythme(62000, 16));
        arr.add(new Rythme(62250, 1));
        arr.add(new Rythme(62500, 2));
        arr.add(new Rythme(62750, 4));
        arr.add(new Rythme(63000, 8));
        arr.add(new Rythme(63250, 16));
        arr.add(new Rythme(63500, 4));
        arr.add(new Rythme(63750, 8));
        arr.add(new Rythme(64000, 16));
        arr.add(new Rythme(64250, 1));
        arr.add(new Rythme(64500, 2));
        arr.add(new Rythme(64750, 4));
        arr.add(new Rythme(65000, 8));
        arr.add(new Rythme(65250, 16));
        arr.add(new Rythme(65500, 4));
        arr.add(new Rythme(65750, 8));
        arr.add(new Rythme(66000, 16));
        arr.add(new Rythme(66250, 1));
        arr.add(new Rythme(66500, 2));
        arr.add(new Rythme(66750, 4));
        arr.add(new Rythme(67000, 8));
        arr.add(new Rythme(67250, 16));
        arr.add(new Rythme(67500, 4));
        arr.add(new Rythme(67750, 8));
        arr.add(new Rythme(68000, 16));
        arr.add(new Rythme(68250, 1));
        arr.add(new Rythme(68500, 2));
        arr.add(new Rythme(68750, 4));
        arr.add(new Rythme(69000, 8));
        arr.add(new Rythme(69250, 16));
        arr.add(new Rythme(69500, 4));
        arr.add(new Rythme(69750, 8));
        arr.add(new Rythme(70000, 16));
        arr.add(new Rythme(70250, 1));
        arr.add(new Rythme(70500, 2));
        arr.add(new Rythme(70750, 4));
        arr.add(new Rythme(71000, 8));
        arr.add(new Rythme(71250, 16));
        arr.add(new Rythme(71500, 4));
        arr.add(new Rythme(71750, 8));
        arr.add(new Rythme(72000, 16));
        arr.add(new Rythme(72250, 1));
        arr.add(new Rythme(72500, 2));
        arr.add(new Rythme(72750, 4));
        arr.add(new Rythme(73000, 8));
        arr.add(new Rythme(73250, 16));
        arr.add(new Rythme(73500, 4));
        arr.add(new Rythme(73750, 8));
        arr.add(new Rythme(74000, 16));
        arr.add(new Rythme(74250, 1));
        arr.add(new Rythme(74500, 2));
        arr.add(new Rythme(74750, 4));
        arr.add(new Rythme(75000, 8));
        arr.add(new Rythme(75250, 16));
        arr.add(new Rythme(75500, 4));
        arr.add(new Rythme(75750, 8));
        arr.add(new Rythme(76000, 16));
        arr.add(new Rythme(76250, 1));
        arr.add(new Rythme(76500, 2));
        arr.add(new Rythme(76750, 4));
        arr.add(new Rythme(77000, 8));
        arr.add(new Rythme(77250, 16));
        arr.add(new Rythme(77500, 4));
        arr.add(new Rythme(77750, 8));
        arr.add(new Rythme(78000, 16));
        arr.add(new Rythme(78250, 1));
        arr.add(new Rythme(78500, 2));
        arr.add(new Rythme(78750, 4));
        arr.add(new Rythme(79000, 8));
        arr.add(new Rythme(79250, 16));
        arr.add(new Rythme(79500, 4));
        arr.add(new Rythme(79750, 8));
        arr.add(new Rythme(80000, 16));
        arr.add(new Rythme(80250, 1));
        arr.add(new Rythme(80500, 2));
        arr.add(new Rythme(80750, 4));
        arr.add(new Rythme(81000, 8));
        arr.add(new Rythme(81250, 16));
        arr.add(new Rythme(81500, 4));
        arr.add(new Rythme(81750, 8));
        arr.add(new Rythme(82000, 16));
        arr.add(new Rythme(82250, 1));
        arr.add(new Rythme(82500, 2));
        arr.add(new Rythme(82750, 4));
        arr.add(new Rythme(83000, 8));
        arr.add(new Rythme(83250, 16));
        arr.add(new Rythme(83500, 4));
        arr.add(new Rythme(83750, 8));
        arr.add(new Rythme(84000, 16));
        arr.add(new Rythme(84250, 1));
        arr.add(new Rythme(84500, 2));
        arr.add(new Rythme(84750, 4));
        arr.add(new Rythme(85000, 8));
        arr.add(new Rythme(85250, 16));
        arr.add(new Rythme(85500, 4));
        arr.add(new Rythme(85750, 8));
        arr.add(new Rythme(86000, 16));
        arr.add(new Rythme(86250, 1));
        arr.add(new Rythme(86500, 2));
        arr.add(new Rythme(86750, 4));
        arr.add(new Rythme(87000, 8));
        arr.add(new Rythme(87250, 16));
        arr.add(new Rythme(87500, 4));
        arr.add(new Rythme(87750, 8));
        arr.add(new Rythme(88000, 16));
        arr.add(new Rythme(88250, 1));
        arr.add(new Rythme(88500, 2));
        arr.add(new Rythme(88750, 4));
        arr.add(new Rythme(89000, 8));
        arr.add(new Rythme(89250, 16));
        arr.add(new Rythme(89500, 4));
        arr.add(new Rythme(89750, 8));
        arr.add(new Rythme(90000, 16));
        arr.add(new Rythme(90250, 1));
        arr.add(new Rythme(90500, 2));
        arr.add(new Rythme(90750, 4));
        arr.add(new Rythme(91000, 8));
        arr.add(new Rythme(91250, 16));
        arr.add(new Rythme(91500, 4));
        arr.add(new Rythme(91750, 8));
        arr.add(new Rythme(92000, 16));
        arr.add(new Rythme(92250, 1));
        arr.add(new Rythme(92500, 2));
        arr.add(new Rythme(92750, 4));
        arr.add(new Rythme(93000, 8));
        arr.add(new Rythme(93250, 16));
        arr.add(new Rythme(93500, 4));
        arr.add(new Rythme(93750, 8));
        arr.add(new Rythme(94000, 16));
        arr.add(new Rythme(94250, 1));
        arr.add(new Rythme(94500, 2));
        arr.add(new Rythme(94750, 4));
        arr.add(new Rythme(95000, 8));
        arr.add(new Rythme(95250, 16));
        arr.add(new Rythme(95500, 4));
        arr.add(new Rythme(95750, 8));
        arr.add(new Rythme(96000, 16));
        arr.add(new Rythme(96250, 1));
        arr.add(new Rythme(96500, 2));
        arr.add(new Rythme(96750, 4));
        arr.add(new Rythme(97000, 8));
        arr.add(new Rythme(97250, 16));
        arr.add(new Rythme(97500, 4));
        arr.add(new Rythme(97750, 8));
        arr.add(new Rythme(98000, 16));
        arr.add(new Rythme(98250, 1));
        arr.add(new Rythme(98500, 2));
        arr.add(new Rythme(98750, 4));
        arr.add(new Rythme(99000, 8));
        arr.add(new Rythme(99250, 16));
        arr.add(new Rythme(99500, 4));
        arr.add(new Rythme(99750, 8));
        arr.add(new Rythme(100000, 16));
        arr.add(new Rythme(100250, 1));
        arr.add(new Rythme(100500, 2));
        arr.add(new Rythme(100750, 4));
        arr.add(new Rythme(101000, 8));
        arr.add(new Rythme(101250, 16));
        arr.add(new Rythme(101500, 4));
        arr.add(new Rythme(101750, 8));
        arr.add(new Rythme(102000, 16));
        arr.add(new Rythme(102250, 1));
        arr.add(new Rythme(102500, 2));
        arr.add(new Rythme(102750, 4));
        arr.add(new Rythme(103000, 8));
        arr.add(new Rythme(103250, 16));
        arr.add(new Rythme(103500, 4));
        arr.add(new Rythme(103750, 8));
        arr.add(new Rythme(104000, 16));
        arr.add(new Rythme(104250, 1));
        arr.add(new Rythme(104500, 2));
        arr.add(new Rythme(104750, 4));
        arr.add(new Rythme(105000, 8));
        arr.add(new Rythme(105250, 16));
        arr.add(new Rythme(105500, 4));
        arr.add(new Rythme(105750, 8));
        arr.add(new Rythme(106000, 16));
        arr.add(new Rythme(106250, 1));
        arr.add(new Rythme(106500, 2));
        arr.add(new Rythme(106750, 4));
        arr.add(new Rythme(107000, 8));
        arr.add(new Rythme(107250, 16));
        arr.add(new Rythme(107500, 4));
        arr.add(new Rythme(107750, 8));
        arr.add(new Rythme(108000, 16));
        arr.add(new Rythme(108250, 1));
        arr.add(new Rythme(108500, 2));
        arr.add(new Rythme(108750, 4));
        arr.add(new Rythme(109000, 8));
        arr.add(new Rythme(109250, 16));
        arr.add(new Rythme(109500, 4));
        arr.add(new Rythme(109750, 8));
        arr.add(new Rythme(110000, 16));
        arr.add(new Rythme(110250, 1));
        arr.add(new Rythme(110500, 2));
        arr.add(new Rythme(110750, 4));
        arr.add(new Rythme(111000, 8));
        arr.add(new Rythme(111250, 16));
        arr.add(new Rythme(111500, 4));
        arr.add(new Rythme(111750, 8));
        arr.add(new Rythme(112000, 16));
        arr.add(new Rythme(112250, 1));
        arr.add(new Rythme(112500, 2));
        arr.add(new Rythme(112750, 4));
        arr.add(new Rythme(113000, 8));
        arr.add(new Rythme(113250, 16));
        arr.add(new Rythme(113500, 4));
        arr.add(new Rythme(113750, 8));
        arr.add(new Rythme(114000, 16));
        arr.add(new Rythme(114250, 1));
        arr.add(new Rythme(114500, 2));
        arr.add(new Rythme(114750, 4));
        arr.add(new Rythme(115000, 8));
        arr.add(new Rythme(115250, 16));
        arr.add(new Rythme(115500, 4));
        arr.add(new Rythme(115750, 8));
        arr.add(new Rythme(116000, 16));
        arr.add(new Rythme(116250, 1));
        arr.add(new Rythme(116500, 2));
        arr.add(new Rythme(116750, 4));
        arr.add(new Rythme(117000, 8));
        arr.add(new Rythme(117250, 16));
        arr.add(new Rythme(117500, 4));
        arr.add(new Rythme(117750, 8));
        arr.add(new Rythme(118000, 16));
        arr.add(new Rythme(118250, 1));
        arr.add(new Rythme(118500, 2));
        arr.add(new Rythme(118750, 4));
        arr.add(new Rythme(119000, 8));
        arr.add(new Rythme(119250, 16));
        arr.add(new Rythme(119500, 4));
        arr.add(new Rythme(119750, 8));
        arr.add(new Rythme(120000, 16));
        arr.add(new Rythme(120250, 1));
        arr.add(new Rythme(120500, 2));
        arr.add(new Rythme(120750, 4));
        arr.add(new Rythme(121000, 8));
        arr.add(new Rythme(121250, 16));
        arr.add(new Rythme(121500, 4));
        arr.add(new Rythme(121750, 8));
        arr.add(new Rythme(122000, 16));
        arr.add(new Rythme(122250, 1));
        arr.add(new Rythme(122500, 2));
        arr.add(new Rythme(122750, 4));
        arr.add(new Rythme(123000, 8));
        arr.add(new Rythme(123250, 16));
        arr.add(new Rythme(123500, 4));
        arr.add(new Rythme(123750, 8));
        arr.add(new Rythme(124000, 16));
        arr.add(new Rythme(124250, 1));
        arr.add(new Rythme(124500, 2));
        arr.add(new Rythme(124750, 4));
        arr.add(new Rythme(125000, 8));
        arr.add(new Rythme(125250, 16));
        arr.add(new Rythme(125500, 4));
        arr.add(new Rythme(125750, 8));
        arr.add(new Rythme(126000, 16));
        arr.add(new Rythme(126250, 1));
        arr.add(new Rythme(126500, 2));
        arr.add(new Rythme(126750, 4));
        arr.add(new Rythme(127000, 8));
        arr.add(new Rythme(127250, 16));
        arr.add(new Rythme(127500, 4));
        arr.add(new Rythme(127750, 8));
        arr.add(new Rythme(128000, 16));
        arr.add(new Rythme(128250, 1));
        arr.add(new Rythme(128500, 2));
        arr.add(new Rythme(128750, 4));
        arr.add(new Rythme(129000, 8));
        arr.add(new Rythme(129250, 16));
        arr.add(new Rythme(129500, 24));
        arr.add(new Rythme(129750, 8));
        arr.add(new Rythme(130000, 4));
        arr.add(new Rythme(130250, 16));
        arr.add(new Rythme(130500, 8));
        arr.add(new Rythme(130750, 4));
        arr.add(new Rythme(131000, 8));
        arr.add(new Rythme(131250, 4));
        arr.add(new Rythme(131500, 2));
        arr.add(new Rythme(131750, 4));
        arr.add(new Rythme(132000, 2));
        arr.add(new Rythme(132250, 1));
        arr.add(new Rythme(132500, 2));
        arr.add(new Rythme(132750, 4));
        arr.add(new Rythme(133000, 8));
        arr.add(new Rythme(133250, 16));
        arr.add(new Rythme(133500, 24));
        arr.add(new Rythme(133750, 8));
        arr.add(new Rythme(134000, 4));
        arr.add(new Rythme(134250, 8));
        arr.add(new Rythme(134500, 4));
        arr.add(new Rythme(134750, 2));
        arr.add(new Rythme(135000, 4));
        arr.add(new Rythme(135250, 1));
        arr.add(new Rythme(135500, 4));
        arr.add(new Rythme(135750, 2));
        arr.add(new Rythme(136000, 1));
        arr.add(new Rythme(136250, 14));
    }
}