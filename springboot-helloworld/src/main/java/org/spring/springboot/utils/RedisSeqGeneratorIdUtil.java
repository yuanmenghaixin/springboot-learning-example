package org.spring.springboot.utils;

/*import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.google.common.base.Preconditions.checkArgument;*/
/**
 * Created by Peng.lv on 2017/11/3.
 */
public class RedisSeqGeneratorIdUtil {
   /* private static final Logger logger = LoggerFactory.getLogger(SeqGenerator.class);
    private static final Path filePath = Paths.get(Thread.currentThread().getContextClassLoader().getResource("lua/get_next_seq.lua").getPath());
    //线程安全
    private static final FastDateFormat seqDateFormat = FastDateFormat.getInstance("yyMMddHHmmssSSS");
    private static final RedisExtraService redisExtraService = SpringContext.getBean(RedisExtraService.class);
    private final byte[] keyName;
    private final byte[] incrby;
    private byte[] sha1;
    public SeqGenerator(String keyName) throws IOException {
        this(keyName, 1);
    }
    *//**
     * @param keyName
     * @param incrby
     *//*
    public SeqGenerator(String keyName, int incrby) throws IOException {
        checkArgument(keyName != null && incrby > 0);
        this.keyName = keyName.getBytes();
        this.incrby = Integer.toString(incrby).getBytes();
        init();
    }
    private void init() throws IOException {
        byte[] script;
        try {
            script = Files.readAllBytes(filePath);
        } catch (IOException e) {
            logger.error("读取文件出错, path: {}", filePath);
            throw e;
        }
        sha1 = redisExtraService.scriptLoad(script);
    }
    public String getNextSeq(String bizType) {
        checkArgument(StringUtils.isNotBlank(bizType));
        return bizType + getMaxSeq();
    }
    private String generateSeq() {
        String seqDate = seqDateFormat.format(System.currentTimeMillis());
        String candidateSeq = new StringBuilder(17).append(seqDate).append(RandomStringUtils.randomNumeric(2)).toString();
        return candidateSeq;
    }
    *//**
     * 通过redis生成17位的序列号,lua脚本保证序列号的唯一性
     *
     * @return
     *//*
    public String getMaxSeq() {
        String maxSeq = new String((byte[]) redisExtraService.evalsha(sha1, 3, keyName, incrby, generateSeq().getBytes()));
        return maxSeq;
    }*/
}
