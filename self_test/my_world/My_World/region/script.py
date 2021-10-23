import anvil

region = anvil.Region.from_file('D:/ctf2021/self_test/my_world/My_World/region/r.4166.-1.mca')

chunk = anvil.Chunk.from_region(region, 0, 0)
block = chunk.get_block(0, 0, 0)
print(block) # <Block(minecraft:air)>

print(block)
print(block.id) # air
print(block.properties) # {}