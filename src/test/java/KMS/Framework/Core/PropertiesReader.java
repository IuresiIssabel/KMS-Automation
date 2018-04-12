package KMS.Framework.Core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties prop;
    private String INPUT_FILE_PATH = "./general.properties";
    private InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream(INPUT_FILE_PATH);

    public PropertiesReader() {
        prop = new Properties();
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }

    public String getBaseUrl() {
        return prop.getProperty("base.url");
    }

    public Integer getMetricScoreDropdownMaxNr() {
        return Integer.valueOf(prop.getProperty("MetricScoreDropdownMaxNr"));
    }

    public Integer getMetricValueDropdownMaxNr() {
        return Integer.valueOf(prop.getProperty("MetricValueDropdownMaxNr"));
    }

    public Integer getMetricGoalDropdownMaxNr() {
        return Integer.valueOf(prop.getProperty("MetricGoalDropdownMaxNr"));
    }

    public Integer getMetricValueGoalMinutesAndPercentageNr() {
        return Integer.valueOf(prop.getProperty("MetricValue.GoalMinutesAndPercentageNr"));
    }

    public String getKmsAutoProjectName() {
        return prop.getProperty("kmsAutoProjectName");
    }

    public String getEMField() {
        return prop.getProperty("EMField");
    }

    public String getEMField2() {
        return prop.getProperty("EMField2");
    }

    public String getDoEField() {
        return prop.getProperty("DoEField");
    }

    public String getDoEField2() {
        return prop.getProperty("DoEField2");
    }

    public String getClientField() {
        return prop.getProperty("clientField");
    }

    public String getClientField2() {
        return prop.getProperty("clientField2");
    }

    public String getCommentField() {
        return prop.getProperty("CommentField");
    }

    public String getColumn1() {
        return prop.getProperty("Column1");
    }

    public String getColumn2() {
        return prop.getProperty("Column2");
    }

    public String getColumn3() {
        return prop.getProperty("Column3");
    }

    public String getColumn4() {
        return prop.getProperty("Column4");
    }

    public String getColumn5() {
        return prop.getProperty("Column5");
    }

    public String getColumn6() {
        return prop.getProperty("Column6");
    }

    public String getColumn7() {
        return prop.getProperty("Column7");
    }

    public String getColumn8() {
        return prop.getProperty("Column8");
    }

    public String getMetricCategory1() {
        return prop.getProperty("MetricCategory1");
    }

    public String geMetricCategory2() {
        return prop.getProperty("MetricCategory2");
    }

    public String getMetricCategory3() {
        return prop.getProperty("MetricCategory3");
    }

    public String getMetricCategory4() {
        return prop.getProperty("MetricCategory4");
    }

    public String getMetricCategory5() {
        return prop.getProperty("MetricCategory5");
    }

    public String getNoResultFoundMessage() {
        return prop.getProperty("noResultFoundMessage");
    }
}