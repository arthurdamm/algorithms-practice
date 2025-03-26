/*
Key Insights:
(This is like 2 interval problems together)
or/and with a scanline

Sort twice in both dimensions then:

1. need to only check cuts at the vertical and horizontal boundaries of the rectangles.
Because If a cut is valid at a line where no rectangles intersect we can always move it
to the next boundary, which may be one or more rectangles.

2. We only start cutting after the passing of the outer rectangle, so this guarantees that the
two outer cuts have at least 1 rectangle.
2b. But the mdidle cut could be empty? No, because if we increment by boundaries then we can
confirm that we iterated past at least 1 rectangle
2b. REFINE ABOVE

Two cuts thoughts:
do we need some kind of backtracking? No, greedy is sufficient, if we iterate past boundaries correctly and make
sure there is at least one more rectangle left in the dimension all conditions are met.

Checking intersections:
How to make sure no cut cuts a rectangle? keep a mapping of "open rectangles" as we iterate?
Do we need to reformat this as start/stop events?


*/
class Solution {
public:
    bool checkValidCuts(int n, vector<vector<int>>& rectangles) {
        vector<pair<int, char>> horizontal_events, vertical_events;
        for (const auto& rect : rectangles) {
            horizontal_events.push_back({rect[0], 'A'});
            horizontal_events.push_back({rect[2], 'B'});
            vertical_events.push_back({rect[1], 'A'});
            vertical_events.push_back({rect[3], 'B'});
        }
        if (parse_events(horizontal_events)) {
            return true;
        }
        if (parse_events(vertical_events)) {
            return true;
        }
        return false;
        
    }

    bool parse_events(vector<pair<int, char>>& events) {
        auto compare = [](const pair<int, char>&a, const pair<int, char>&b) {
            if (a.first == b.first) {
                return a.second > b.second;
            }
            return a.first < b.first;
        };
        std::sort(events.begin(), events.end(), compare);
        ssize_t open_stack = 0, prev_cut = -1, prev_event = -1;
        for (size_t i = 0; i < events.size(); i++) {
            if (events[i].second == 'B') {
                open_stack--;
            }
            // try to make a cut
            if (!open_stack && events[i].first > events[0].first) { // at least one rectangle before us
                // cout << "try cut" << endl;

                if (prev_cut == -1) {
                    prev_cut = events[i].first;
                } 
                // if we have a cut already and there are rectangles after us, AND an event occured between cuts
                // (so not empty region), success
                else if (prev_cut != events[i].first && events[i].first < events.back().first && prev_event != prev_cut) {
                    return true;
                }
            }
            if (events[i].second == 'A') {
                open_stack++;
            }
            prev_event = events[i].first;

        }
        return false;
    }
};

