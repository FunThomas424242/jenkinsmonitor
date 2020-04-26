var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":63,"id":1073,"methods":[{"el":36,"sc":5,"sl":33},{"el":41,"sc":5,"sl":38},{"el":46,"sc":5,"sl":43},{"el":51,"sc":5,"sl":48},{"el":57,"sc":5,"sl":53},{"el":61,"sc":5,"sl":59}],"name":"TestDrivenTimer","sl":30}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_13":{"methods":[{"sl":33},{"sl":38}],"name":"shouldShowOneInstabilJobWatching","pass":true,"statements":[{"sl":35}]},"test_17":{"methods":[{"sl":33},{"sl":38},{"sl":48},{"sl":53},{"sl":59}],"name":"updateJobsAfterTimePeriod","pass":true,"statements":[{"sl":35},{"sl":56},{"sl":60}]},"test_26":{"methods":[{"sl":33},{"sl":38}],"name":"shouldShowOneFailedJobWatching","pass":true,"statements":[{"sl":35}]},"test_39":{"methods":[{"sl":33},{"sl":38}],"name":"showStatusAsToolstippsIfJobsPresent","pass":true,"statements":[{"sl":35}]},"test_47":{"methods":[{"sl":33},{"sl":38}],"name":"showStatusAsToolstippsIfJobPresent","pass":true,"statements":[{"sl":35}]},"test_8":{"methods":[{"sl":33},{"sl":38}],"name":"shouldShowOneSuccessJobWatching","pass":true,"statements":[{"sl":35}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [17, 8, 26, 13, 39, 47], [], [17, 8, 26, 13, 39, 47], [], [], [17, 8, 26, 13, 39, 47], [], [], [], [], [], [], [], [], [], [17], [], [], [], [], [17], [], [], [17], [], [], [17], [17], [], [], []]