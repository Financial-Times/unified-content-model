package com.ft.unifiedContentModel.marshalling.bind;

import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

public class CustomJaxbAnnotationIntrospector extends JaxbAnnotationIntrospector {
	
	@Override
	protected TypeResolverBuilder<?> _typeResolverFromXmlElements(AnnotatedMember am)
    {
        /* If simple type, @XmlElements and @XmlElementRefs are applicable.
         * Note: @XmlElement and @XmlElementRef are NOT handled here, since they
         * are handled specifically as non-polymorphic indication
         * of the actual type
         */
        XmlElements elems = findAnnotation(XmlElements.class, am, false, false, false);
        XmlElementRefs elemRefs = findAnnotation(XmlElementRefs.class, am, false, false, false);
        if (elems == null && elemRefs == null) {
            return null;
        }

        TypeResolverBuilder<?> b = new StdTypeResolverBuilder();
        // JAXB always uses type name as id
        b = b.init(JsonTypeInfo.Id.NAME, null);
        // we want to use the PROPERTY inclusion method rather than WRAPPER
        b = b.inclusion(JsonTypeInfo.As.PROPERTY);
        // and we want to set the property type as 'type'
        b=b.typeProperty("type");
        return b;        
    }

}
