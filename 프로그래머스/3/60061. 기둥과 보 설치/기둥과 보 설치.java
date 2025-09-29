import java.util.*;

class Solution {
    static final int PILLAR = 0;
    static final int BEAM = 1;

    public int[][] solution(int n, int[][] build_frame) {
        // 구조물 저장 (x,y,type)
        List<int[]> structures = new ArrayList<>();

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int build = frame[3];

            if (build == 1) { // 설치
                structures.add(new int[]{x, y, type});
                if (!check(structures)) { // 규칙에 맞지 않으면 취소
                    structures.remove(structures.size() - 1);
                }
            } else { // 삭제
                // 해당 구조물 삭제 후 규칙 검사
                int idx = -1;
                for (int i = 0; i < structures.size(); i++) {
                    if (Arrays.equals(structures.get(i), new int[]{x, y, type})) {
                        idx = i;
                        break;
                    }
                }
                if (idx != -1) {
                    int[] removed = structures.remove(idx);
                    if (!check(structures)) { // 규칙 안 맞으면 복구
                        structures.add(removed);
                    }
                }
            }
        }

        // 정렬 (x, y, type)
        structures.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        return structures.toArray(new int[structures.size()][]);
    }

    // 규칙 검사
    private boolean check(List<int[]> structures) {
        for (int[] s : structures) {
            int x = s[0];
            int y = s[1];
            int type = s[2];

            if (type == PILLAR) { // 기둥
                if (y == 0 || exist(structures, x, y - 1, PILLAR)
                        || exist(structures, x - 1, y, BEAM)
                        || exist(structures, x, y, BEAM)) {
                    continue;
                }
                return false;
            } else { // 보
                if (exist(structures, x, y - 1, PILLAR)
                        || exist(structures, x + 1, y - 1, PILLAR)
                        || (exist(structures, x - 1, y, BEAM)
                            && exist(structures, x + 1, y, BEAM))) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    // 특정 위치에 구조물 있는지 확인
    private boolean exist(List<int[]> structures, int x, int y, int type) {
        for (int[] s : structures) {
            if (s[0] == x && s[1] == y && s[2] == type) return true;
        }
        return false;
    }
}
