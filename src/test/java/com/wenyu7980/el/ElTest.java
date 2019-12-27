package com.wenyu7980.el;

import com.wenyu7980.el.data.ContextFunction;
import com.wenyu7980.el.data.Data;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 *
 * @author:wenyu
 * @date:2019/12/25
 */
public class ElTest {
    @Test
    public void testCompute() {
        Assert.assertEquals(0, BigDecimal.valueOf(3).compareTo(
                ExpressionLanguages.parse("1+2;", BigDecimal.class)));
        Assert.assertEquals(0, BigDecimal.valueOf(-1).compareTo(
                ExpressionLanguages.parse("1-2;", BigDecimal.class)));
        Assert.assertEquals(0, BigDecimal.valueOf(2).compareTo(
                ExpressionLanguages.parse("1*2;", BigDecimal.class)));
        Assert.assertEquals(0, BigDecimal.valueOf(0.5).compareTo(
                ExpressionLanguages.parse("1/2;", BigDecimal.class)));
        Assert.assertEquals(0, BigDecimal.valueOf(2).compareTo(
                ExpressionLanguages.parse("1/2+1.5;", BigDecimal.class)));
        Assert.assertEquals(0, BigDecimal.valueOf(3.5).compareTo(
                ExpressionLanguages.parse("1*2+1.5;", BigDecimal.class)));
    }

    @Test
    public void testCompare() {
        Assert.assertEquals(true,
                ExpressionLanguages.parse("1>0;", Boolean.class));
        Assert.assertEquals(false,
                ExpressionLanguages.parse("1>1;", Boolean.class));
        Assert.assertEquals(false,
                ExpressionLanguages.parse("0>1;", Boolean.class));
        Assert.assertEquals(true,
                ExpressionLanguages.parse("1>=0;", Boolean.class));
        Assert.assertEquals(true,
                ExpressionLanguages.parse("1>=1;", Boolean.class));
        Assert.assertEquals(false,
                ExpressionLanguages.parse("0>=1;", Boolean.class));
        Assert.assertEquals(false,
                ExpressionLanguages.parse("1<0;", Boolean.class));
        Assert.assertEquals(false,
                ExpressionLanguages.parse("1<1;", Boolean.class));
        Assert.assertEquals(true,
                ExpressionLanguages.parse("0<1;", Boolean.class));
        Assert.assertEquals(false,
                ExpressionLanguages.parse("1<=0;", Boolean.class));
        Assert.assertEquals(true,
                ExpressionLanguages.parse("1<=1;", Boolean.class));
        Assert.assertEquals(true,
                ExpressionLanguages.parse("0<=1;", Boolean.class));
        Assert.assertEquals(false,
                ExpressionLanguages.parse("1==0;", Boolean.class));
        Assert.assertEquals(true,
                ExpressionLanguages.parse("1==1;", Boolean.class));
        Assert.assertEquals(true,
                ExpressionLanguages.parse("1<>0;", Boolean.class));
        Assert.assertEquals(false,
                ExpressionLanguages.parse("1<>1;", Boolean.class));
    }

    @Test
    public void testLogic() {
        Assert.assertEquals(true,
                ExpressionLanguages.parse("1>0 && 2>1;", Boolean.class));
        Assert.assertEquals(true,
                ExpressionLanguages.parse("1<0 || 1>0;", Boolean.class));
        Assert.assertEquals(false,
                ExpressionLanguages.parse("!1>0;", Boolean.class));
        Assert.assertEquals(false, ExpressionLanguages
                .parse("1<0 && 1 > 0 || 1>0 && 2 < 1;", Boolean.class));
        Assert.assertEquals(false, ExpressionLanguages
                .parse("(1<0 && 1 > 0) || (1>0 && 2 < 1);", Boolean.class));

    }

    @Test
    public void testDataAttribute() {
        Assert.assertEquals("attr", ExpressionLanguages.parse("$.field;",
                new ElContext().addContext("$", new Data("attr")),
                String.class));
    }

    @Test
    public void testFunction() {
        ElContext context = new ElContext()
                .addContext("$", new ContextFunction());
        Assert.assertEquals("zero",
                ExpressionLanguages.parse("$.f();", context, String.class));
        Assert.assertEquals("one", ExpressionLanguages
                .parse("$.f(\"1\");", context, String.class));
        Assert.assertEquals("two", ExpressionLanguages
                .parse("$.f(\"1\",\"1\");", context, String.class));
    }
}
