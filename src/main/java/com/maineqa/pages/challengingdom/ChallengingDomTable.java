package com.maineqa.pages.challengingdom;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.JavascriptExecutor;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;

public class ChallengingDomTable {

    private Document html;
    private List<ChallengingDomRow> tableRows;


    public ChallengingDomTable(String html) {
        init(html);
    }

    public void init(String tablehtml) {
        this.html = Jsoup.parse(tablehtml);
        this.tableRows = new ArrayList<>();
        List<Element> rows = html.getElementsByTag("tr");
        rows.remove(0); // Get rid of header row
        for (Element row : rows) {
            tableRows.add(new ChallengingDomRow(row));
        }
    }

    public ChallengingDomRow getRow(int i) {
        return tableRows.get(i);
    }
}
