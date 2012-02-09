package com.ft.unifiedContentModel.core.datetime;


import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.apache.commons.lang.StringUtils.isNotBlank;
import static org.springframework.util.Assert.notNull;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.ReadableDateTime;


public class DateTimeAdapter extends XmlAdapter<String, ReadableDateTime> {
	
	private DateTimeFormatter dateTimeFormatter;
	
	public DateTimeAdapter() {
		this(new ISODateTimeFormatter());
	}
	
	DateTimeAdapter(DateTimeFormatter dateTimeFormatter) {
		notNull(dateTimeFormatter);
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
    @Override
    public String marshal(ReadableDateTime dateTime) {
        return dateTime != null ? dateTimeFormatter.format(dateTime) : EMPTY;
    }

    @Override
    public ReadableDateTime unmarshal(String dateString) {
         return isNotBlank(dateString) ? dateTimeFormatter.parseDateTime(dateString) : null;
    }
}
