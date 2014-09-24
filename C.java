
import java.util.*;
import first.second.*;
import first.*;

public class C extends A {
    /**
     * @noreverse
     */
    public static final String TECHNICAL_ID = "DEADBEEF";
    public static final String BUSINESS_ID = "ID_C";

    /**
     * @association opposite=linkToC
     */
    private B associatedB;
    protected List<A> childs;
}
