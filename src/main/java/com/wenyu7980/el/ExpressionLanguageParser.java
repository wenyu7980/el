/* ExpressionLanguageParser.java */
/* Generated By:JavaCC: Do not edit this line. ExpressionLanguageParser.java */
package com.wenyu7980.el;

import java.math.BigDecimal;
import java.util.Objects;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.Class;

public class ExpressionLanguageParser implements ExpressionLanguageParserConstants {
    private boolean toBoolean(Object object) {
        return (Boolean) object;
    }

/** statement */
  final public Object statement(ElContext context) throws ParseException {Object obj;
    obj = express(context);
    jj_consume_token(14);
{if ("" != null) return obj;}
    throw new Error("Missing return statement in function");
}

/** express */
  final public Object express(ElContext context) throws ParseException {Object obj;
    obj = ternary(context);
{if ("" != null) return obj;}
    throw new Error("Missing return statement in function");
}

/** ternary */
  final public Object ternary(ElContext context) throws ParseException {Object left;
  Object mid = null;
  Object right = null;
    left = notExpr(context);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 15:{
      jj_consume_token(15);
      mid = express(context);
      jj_consume_token(16);
      right = express(context);
{if ("" != null) return toBoolean(left) ? mid : right;}
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
{if ("" != null) return left;}
    throw new Error("Missing return statement in function");
}

/** logic start */
/** notExpr */
  final public Object notExpr(ElContext context) throws ParseException {Object obj;
  Token t = null;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 17:{
      t = jj_consume_token(17);
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    obj = orExpr(context);
{if ("" != null) return  Objects.isNull(t) ?obj:!toBoolean((obj));}
    throw new Error("Missing return statement in function");
}

/** or */
  final public Object orExpr(ElContext context) throws ParseException {Object left;
  Object right;
    left = andExpr(context);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 18:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
      jj_consume_token(18);
      right = andExpr(context);
left = toBoolean(left) || toBoolean(right);
      if (toBoolean(left)){
        {if ("" != null) return true;}
      }
    }
{if ("" != null) return left;}
    throw new Error("Missing return statement in function");
}

/** and */
  final public Object andExpr(ElContext context) throws ParseException {Object left;
  Object right;
    left = compare(context);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 19:{
        ;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      jj_consume_token(19);
      right = compare(context);
left = toBoolean(left) && toBoolean(right);
      if (!toBoolean(left)){
        {if ("" != null) return false;}
      }
    }
{if ("" != null) return left;}
    throw new Error("Missing return statement in function");
}

/** compare */
  final public Object compare(ElContext context) throws ParseException {Object left = null;
    Object right = null;
    left = binary(context);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 20:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 20:{
        jj_consume_token(20);
        right = binary(context);
if (left instanceof Comparable){
          {if ("" != null) return ((Comparable) left).compareTo(right) != 0;}
      }
      {if ("" != null) return !Objects.equals(left,right);}
        break;
        }
      case 21:{
        jj_consume_token(21);
        right = binary(context);
{if ("" != null) return ((Comparable) left).compareTo(right) > 0;}
        break;
        }
      case 22:{
        jj_consume_token(22);
        right = binary(context);
{if ("" != null) return ((Comparable) left).compareTo(right) < 0;}
        break;
        }
      case 23:{
        jj_consume_token(23);
        right = binary(context);
if (left instanceof BigDecimal){
        {if ("" != null) return ((Comparable) left).compareTo(right) == 0;}
      }
       {if ("" != null) return Objects.equals(left,right);}
        break;
        }
      case 24:{
        jj_consume_token(24);
        right = binary(context);
{if ("" != null) return ((Comparable) left).compareTo(right) >= 0;}
        break;
        }
      case 25:{
        jj_consume_token(25);
        right = binary(context);
{if ("" != null) return ((Comparable) left).compareTo(right) <= 0;}
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      ;
    }
{if ("" != null) return left;}
    throw new Error("Missing return statement in function");
}

/** logic end */

/** binary */
  final public Object binary(ElContext context) throws ParseException {Object obj = null;
    obj = plusMinus(context);
{if ("" != null) return obj;}
    throw new Error("Missing return statement in function");
}

/** plusMinus */
  final public Object plusMinus(ElContext context) throws ParseException {Object left = null;
  Object right = null;
    left = multiDiv(context);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 26:
      case 27:{
        ;
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 26:{
        jj_consume_token(26);
        right = multiDiv(context);
left = ((BigDecimal) left).add((BigDecimal) right);
        break;
        }
      case 27:{
        jj_consume_token(27);
        right = multiDiv(context);
left = ((BigDecimal) left).subtract((BigDecimal) right);
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
{if ("" != null) return left;}
    throw new Error("Missing return statement in function");
}

/** multiDiv */
  final public Object multiDiv(ElContext context) throws ParseException {Object left = null;
  Object right = null;
    left = unary(context);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 28:
      case 29:{
        ;
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 28:{
        jj_consume_token(28);
        right = unary(context);
left = ((BigDecimal) left).multiply((BigDecimal) right);
        break;
        }
      case 29:{
        jj_consume_token(29);
        right = unary(context);
left = ((BigDecimal) left).divide((BigDecimal) right);
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
{if ("" != null) return left;}
    throw new Error("Missing return statement in function");
}

/** unary */
  final public Object unary(ElContext context) throws ParseException {Object obj = null;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 27:{
      jj_consume_token(27);
      obj = primary(context);
obj = ((BigDecimal) obj).multiply(new BigDecimal(- 1));
      break;
      }
    case 30:{
      jj_consume_token(30);
      obj = express(context);
      jj_consume_token(31);
      break;
      }
    case NUMBER:
    case IDENTIFIER:
    case STRING:{
      // basic value
          obj = primary(context);
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return obj;}
    throw new Error("Missing return statement in function");
}

/** primary */
  final public Object primary(ElContext context) throws ParseException {Token t = null;
  Object obj = null;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENTIFIER:{
      // variable
          obj = variable(context);
      break;
      }
    case STRING:{
      // String
          t = jj_consume_token(STRING);
String str = t.toString();
      obj = str.substring(1, str.length() - 1);
      break;
      }
    case NUMBER:{
      // number
          t = jj_consume_token(NUMBER);
obj = new BigDecimal(t.toString());
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return obj;}
    throw new Error("Missing return statement in function");
}

/** variable */
  final public Object variable(ElContext context) throws ParseException {Token t;
  Field field = null;
  Object obj = null;
  Object[] parameters=null;
    t = jj_consume_token(IDENTIFIER);
if("null".equals(t.toString()))
      {
        obj = null;
      }
      else
      {
        obj = context.get(t.toString());
      }
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 32:{
        ;
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        break label_5;
      }
      if (jj_2_1(3)) {
        jj_consume_token(32);
        t = jj_consume_token(IDENTIFIER);
        jj_consume_token(30);
        parameters = parameters(context);
        jj_consume_token(31);
try
        {
          Class<?>[] parameterTypes = new Class[parameters.length];
          for (int i = 0 ;i < parameters.length;i++){
            parameterTypes[i] = parameters[i].getClass();
          }
          Method method = obj.getClass().getDeclaredMethod(t.toString(),parameterTypes);
          method.setAccessible(true);
          obj = method.invoke(obj,parameters);
        }
        catch (Exception e)
        {
          {if (true) throw new RuntimeException(e);}
        }
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case 32:{
          jj_consume_token(32);
          t = jj_consume_token(IDENTIFIER);
try
        {
          field = obj.getClass().getDeclaredField(t.toString());
          field.setAccessible(true);
          if (field.getType().isEnum())
          {
            obj = field.get(obj).toString();
          }
          else
          {
            obj = field.get(obj);
          }
        }
        catch (Exception e)
        {
          {if (true) throw new RuntimeException(e);}
        }
          break;
          }
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
{if ("" != null) return obj;}
    throw new Error("Missing return statement in function");
}

/** parameters */
  final public Object[] parameters(ElContext context) throws ParseException {List<Object> list = new ArrayList<Object>();
  Object obj;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NUMBER:
    case IDENTIFIER:
    case STRING:
    case 17:
    case 27:
    case 30:{
      obj = express(context);
list.add(obj);
      break;
      }
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 33:{
        ;
        break;
        }
      default:
        jj_la1[15] = jj_gen;
        break label_6;
      }
      jj_consume_token(33);
      obj = express(context);
list.add(obj);
    }
{if ("" != null) return list.toArray();}
    throw new Error("Missing return statement in function");
}

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_1()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3_1()
 {
    if (jj_scan_token(32)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(30)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public ExpressionLanguageParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[16];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x8000,0x20000,0x40000,0x80000,0x3f00000,0x3f00000,0xc000000,0xc000000,0x30000000,0x30000000,0x48002180,0x2180,0x0,0x0,0x48022180,0x0,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x1,0x0,0x2,};
	}
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public ExpressionLanguageParser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ExpressionLanguageParser(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ExpressionLanguageParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public ExpressionLanguageParser(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new ExpressionLanguageParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ExpressionLanguageParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public ExpressionLanguageParser(ExpressionLanguageParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ExpressionLanguageParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   if (++jj_gc > 100) {
		 jj_gc = 0;
		 for (int i = 0; i < jj_2_rtns.length; i++) {
		   JJCalls c = jj_2_rtns[i];
		   while (c != null) {
			 if (c.gen < jj_gen) c.first = null;
			 c = c.next;
		   }
		 }
	   }
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error {
    @Override
    public Throwable fillInStackTrace() {
      return this;
    }
  }
  static private final LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
	 if (jj_scanpos == jj_lastpos) {
	   jj_la--;
	   if (jj_scanpos.next == null) {
		 jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
	   } else {
		 jj_lastpos = jj_scanpos = jj_scanpos.next;
	   }
	 } else {
	   jj_scanpos = jj_scanpos.next;
	 }
	 if (jj_rescan) {
	   int i = 0; Token tok = token;
	   while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
	   if (tok != null) jj_add_error_token(kind, i);
	 }
	 if (jj_scanpos.kind != kind) return true;
	 if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
	 return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
	 if (pos >= 100) {
		return;
	 }

	 if (pos == jj_endpos + 1) {
	   jj_lasttokens[jj_endpos++] = kind;
	 } else if (jj_endpos != 0) {
	   jj_expentry = new int[jj_endpos];

	   for (int i = 0; i < jj_endpos; i++) {
		 jj_expentry[i] = jj_lasttokens[i];
	   }

	   for (int[] oldentry : jj_expentries) {
		 if (oldentry.length == jj_expentry.length) {
		   boolean isMatched = true;

		   for (int i = 0; i < jj_expentry.length; i++) {
			 if (oldentry[i] != jj_expentry[i]) {
			   isMatched = false;
			   break;
			 }

		   }
		   if (isMatched) {
			 jj_expentries.add(jj_expentry);
			 break;
		   }
		 }
	   }

	   if (pos != 0) {
		 jj_lasttokens[(jj_endpos = pos) - 1] = kind;
	   }
	 }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[34];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 16; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 34; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 jj_endpos = 0;
	 jj_rescan_token();
	 jj_add_error_token(0, 0);
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
	 jj_rescan = true;
	 for (int i = 0; i < 1; i++) {
	   try {
		 JJCalls p = jj_2_rtns[i];

		 do {
		   if (p.gen > jj_gen) {
			 jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
			 switch (i) {
			   case 0: jj_3_1(); break;
			 }
		   }
		   p = p.next;
		 } while (p != null);

		 } catch(LookaheadSuccess ls) { }
	 }
	 jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
	 JJCalls p = jj_2_rtns[index];
	 while (p.gen > jj_gen) {
	   if (p.next == null) { p = p.next = new JJCalls(); break; }
	   p = p.next;
	 }

	 p.gen = jj_gen + xla - jj_la; 
	 p.first = token;
	 p.arg = xla;
  }

  static final class JJCalls {
	 int gen;
	 Token first;
	 int arg;
	 JJCalls next;
  }

}
