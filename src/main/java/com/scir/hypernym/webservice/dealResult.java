package com.scir.hypernym.webservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.model.TripleWithSSID;
import com.scir.hypernym.crawler.BaiduWebClient;

public class dealResult {
    public static final String fos_score_filename = "./Resource/handleResult_score.txt";
    static String FILENAME = "./Resource/input/output_jiang_short.txt";

    public static void dealResult() {

    }

    public ArrayList<Double> pack(ArrayList<TripleWithSSID> tws_s) {
        write_scores_to_fos_score(tws_s);
        File file = new File(fos_score_filename);
        ArrayList<Double> result = new ArrayList<Double>();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString=reader.readLine())!=null){
                result.add(Double.parseDouble(tempString.split("\t")[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return result;
    }

    //
    static private void write_scores_to_fos_score(ArrayList<TripleWithSSID> tws_s) {

        File file = new File(FILENAME);
        BufferedReader reader = null;
        try {
            // System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            FileOutputStream fos = new FileOutputStream("./Resource/handleResult.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

            FileOutputStream fos_score = new FileOutputStream(
                    fos_score_filename);
            OutputStreamWriter osw_score = new OutputStreamWriter(fos_score,
                    "UTF-8");

            BaiduWebClient.Initialize();


            // 一次读入一行，直到读入null为文件结束
            for (TripleWithSSID tws : tws_s) {
                String HeadEntity = tws.triple.HeadEntity;
                String Relation = tws.triple.Relation;
                String TailEntity = tws.triple.TailEntity;
                int SSID = tws.SSID;

//                Vector<String> queryTuple = preHandle(tempString);

                String query = HeadEntity + " " + TailEntity;

                osw.write("(" + HeadEntity + "," + Relation
                        + "," + TailEntity + ")");
                osw.write("\t");

                osw_score.write("(" + HeadEntity + ","
                        + Relation + "," + TailEntity + ")");
                osw_score.write("\t");


                if (skip(tws)) {
                    System.out.println("条件不符，跳过!");
                    osw.write("条件不符，跳过\n");
                    osw_score.write("0.0\tfalse\t0\n");
                    continue;
                }

                System.out.println("query=[" + query + "]");

                DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
                        DateFormat.FULL);
                Date date = new Date();
                String timeStart = df.format(date);
                System.out.println("timeStart:" + timeStart);

                // -------search in Baidu--------

                // BaiduWebClient.search(q, qbefore, qafter, saigo);
                BaiduWebClient.search(query, HeadEntity,
                        Relation, TailEntity,
                        SSID, osw, osw_score);
                Long time = System.currentTimeMillis() - date.getTime();
                double second = time.doubleValue() / 1000;
                // response.getWriter().printf("%f\n", second);
                System.out.println("usedtime:" + second + "s");
                osw.write("\n");
                osw_score.write("\n");
            }
            osw.close();
            osw_score.close();

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    static private boolean skip(TripleWithSSID tws) {
        if (tws.triple.HeadEntity.length() < 2 || tws.triple.Relation.length() < 2 || tws.triple.TailEntity.length() < 2)
            return true;

        return false;

    }
}
