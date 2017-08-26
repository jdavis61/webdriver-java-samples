package com.maineqa.pages.challengingdom;

import org.jsoup.nodes.Element;

public class ChallengingDomRow {

    private Element row;

    public ChallengingDomRow(Element rowElement) {
        this.row = rowElement;
    }

    public String getLorem() {
        return getColumn(0);
    }

    public String getIpsum() {
        return getColumn(1);
    }

    public String getDolor() {
        return getColumn(2);
    }

    public String getSit() {
        return getColumn(3);
    }

    public String getAmet() {
        return getColumn(4);
    }

    public String getDiceret() {
        return getColumn(5);
    }

    String getColumn(int indexPosition) {
        return row.children().tagName("td").get(indexPosition).text();
    }
}
