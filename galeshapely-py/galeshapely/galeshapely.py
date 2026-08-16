
# The Gale-Shapely algorithm.

# A Man is an int
# A Woman is an int
# A Preference is one of
# - List of Men
# - List of Woman
# A Pair is a
# - Man
# - Woman
# A Match is a list of Pair
# A Pair Map is one of
# - map from Man to Woman
# - map from Woman to Man

def propose(proposing_man, woman, pair_map, 
            man_preference_map, woman_preference_map,
            man_proposal_map):

    if proposing_man in man_proposal_map:
        man_proposal_map[proposing_man].append(woman)
    else:
        man_proposal_map[proposing_man] = [woman]

    if woman in pair_map:
        current_man = pair_map[woman]
        proposing_man_rank = woman_preference_map[woman].index(proposing_man)
        current_man_rank = woman_preference_map[woman].index(current_man)

        if proposing_man_rank > current_man_rank:
            del pair_map[current_man]
            pair_map[proposing_man] = woman
            pair_map[woman] = proposing_man
            
    else:
        pair_map[woman] = proposing_man
        pair_map[proposing_man] = woman

    return pair_map, man_proposal_map

def is_pair_map_full(pair_map,
                     man_preference_map,
                     woman_preference_map):
    
    all_matched = True

    for m in man_preference_map:
        if m not in pair_map:
            all_matched = False

    for w in woman_preference_map:
        if w not in pair_map:
            all_matched = False

    return all_matched

def get_highest_rank_woman(man,
                           man_proposal_map,
                           man_preference_map):
    
    woman_list = man_preference_map[man]

    highest_index = 0
    highest = woman_list[highest_index]

    if man in man_proposal_map:
        while highest in man_proposal_map[man]:
            highest_index += 1
            highest = woman_list[highest_index]

    return highest
    

def get_pair_map(man_preference_map, woman_preference_map):
    
    # in
    # man_list List of Man
    # woman_list List of Woman
    # man_preference_list map from Man to Preference
    # woman_preference_list map from Woman to Preference
    # out
    # Match

    pair_map = dict()
    man_proposal_map = dict()

    while not is_pair_map_full(pair_map,
                               man_preference_map,
                               woman_preference_map):
        
        print(pair_map)

        for m in man_preference_map:

            if m not in pair_map:

                w = get_highest_rank_woman(m,
                                           man_proposal_map,
                                           man_preference_map)
                
                pair_map, man_proposal_map = propose(m, w,
                                                     pair_map,
                                                     man_preference_map,
                                                     woman_preference_map,
                                                     man_proposal_map)

    return pair_map
    

