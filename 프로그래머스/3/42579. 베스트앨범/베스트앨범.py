# classic pop classic classic pop
# 500     600 150     800    2500
# {classic : 1450, pop : 3100}
# {classic: [3, 800], [0, 500]}
def solution(genres, plays):
    best_plays_genre = {}
    best_plays_in_genre = {}
    n = len(genres)
    # 1번
    for i in range(n):
        genre = genres[i]
        play = plays[i]
        if genre in best_plays_genre:
            best_plays_genre[genre] += play
            best_plays_in_genre[genre] += [[i, play]]
        else:
            best_plays_genre[genre] = play
            best_plays_in_genre[genre] = [[i, play]]
    # 장르별로 //play 값 2개씩 //많이 재생된 노래순으로 출력
    # 많이 재생된 순으로 정렬
    result = []
    # 가장 많이 재생된 장르 딕셔너리를 배열로 가져오기
    sorted_best_plays_genre = sorted(best_plays_genre.items(), reverse=True, key= lambda x: x[1])
    
    for genre, _value in sorted_best_plays_genre:
        # 각 장르 마다 [인덱스, 재생수] 리스트로 가져오기
        index_play_array = best_plays_in_genre[genre]
        # 각 장르별 많이 재생된 순서로 정렬
        sorted_best_plays_in_genre = sorted(index_play_array, reverse=True, key= lambda x: x[1])
        cnt = 0
        for idx, play in sorted_best_plays_in_genre:
            if cnt >= 2:
                break
            result.append(idx)
            cnt += 1
    return result