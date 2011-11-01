package org.jetbrains.jet.j2k.ast;

import junit.framework.Assert;
import org.jetbrains.jet.j2k.JetTestCaseBase;

/**
 * @author ignatov
 */
public class ArrayTypeTest extends JetTestCaseBase {
  public void testNewStringArray() throws Exception {
    Assert.assertEquals(
      statementToKotlin("String[] a = new String[]{\"abc\"}"),
      "var a : Array<String?>? = array(\"abc\")"
    );
  }

  public void testNewIntArray() throws Exception {
    Assert.assertEquals(
      statementToKotlin("int[] a = new int[]{1, 2, 3}"),
      "var a : IntArray? = array(1, 2, 3)"
    );
  }

  public void testDoubleArray() throws Exception {
    Assert.assertEquals(
      statementToKotlin("double[] a = new double[]{1, 2, 3}"),
      "var a : DoubleArray? = array(1, 2, 3)"
    );
  }

  public void testLongArray() throws Exception {
    Assert.assertEquals(
      statementToKotlin("long[] a = new long[]{1, 2, 3}"),
      "var a : LongArray? = array(1, 2, 3)"
    );
  }

  public void testMethodArrayArgs() throws Exception {
    Assert.assertEquals(
      methodToSingleLineKotlin("void fromArrayToCollection(Foo[] a) {}"),
      "fun fromArrayToCollection(a : Array<Foo?>?) : Unit { }"
    );
  }
}
