var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":90,"id":1276,"methods":[{"el":44,"sc":5,"sl":41},{"el":54,"sc":5,"sl":46},{"el":64,"sc":5,"sl":57},{"el":72,"sc":5,"sl":66},{"el":80,"sc":5,"sl":74},{"el":88,"sc":5,"sl":82}],"name":"JobBeschreibungTest","sl":36}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":82}],"name":"fehlerhafteJobsSindRot","pass":true,"statements":[{"sl":85},{"sl":87}]},"test_18":{"methods":[{"sl":57}],"name":"valideInitialisierung","pass":true,"statements":[{"sl":60},{"sl":62},{"sl":63}]},"test_38":{"methods":[{"sl":46}],"name":"checkEqualsAndHashCode","pass":true,"statements":[{"sl":49},{"sl":50}]},"test_43":{"methods":[{"sl":66}],"name":"erfolgreicheJobsSindGruen","pass":true,"statements":[{"sl":69},{"sl":71}]},"test_6":{"methods":[{"sl":74}],"name":"instabileJobsSindGelb","pass":true,"statements":[{"sl":77},{"sl":79}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [38], [], [], [38], [38], [], [], [], [], [], [], [18], [], [], [18], [], [18], [18], [], [], [43], [], [], [43], [], [43], [], [], [6], [], [], [6], [], [6], [], [], [10], [], [], [10], [], [10], [], [], []]