// @skip-test
// Test case for Issue 862
// https://github.com/typetools/checker-framework/issues/862

package pkg3;

import pkg2.Class2;
import tests.util.Odd;
import tests.util.RequiresOdd;

// @skip-test
public class Issue862 {
    void illegalUse(Class2 class2) {
        //:: error: (contracts.precondition.not.satisfied)
        class2.requiresOdd();
    }

    void legalUse(Class2 class2) {
        class2.ensuresOdd();
        class2.requiresOdd();
    }
}
